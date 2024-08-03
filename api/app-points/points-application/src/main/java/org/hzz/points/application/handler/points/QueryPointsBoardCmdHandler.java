package org.hzz.points.application.handler.points;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.points.application.command.points.QueryPointsBoardCmd;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.service.points.PointsBoardDomainService;
import org.hzz.points.types.resp.PointsBoardItemVo;
import org.hzz.points.types.resp.PointsBoardVo;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.service.details.UserDetailDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Component
@Slf4j
public class QueryPointsBoardCmdHandler implements CommandHandler,
        AbstractExecuteStrategy<QueryPointsBoardCmd, PointsBoardVo> {

    @Setter(onMethod_ = @Autowired)
    private PointsBoardDomainService boardDomainService;

    @Setter(onMethod_ = @Autowired)
    private UserDetailDomainService userDetailDomainService;

    @Override
    public String mark() {
        return QueryPointsBoardCmd.MARK;
    }

    /**
     * 查询积分排行榜
     * todo 整理笔记
     */
    @Override
    public PointsBoardVo executeWithResp(QueryPointsBoardCmd cmd) {
        try {
            return cmd.currentOrHistory() ? handleCurrentSeason(cmd) : handleHistorySeason(cmd);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 处理当前赛季
     */
    private PointsBoardVo handleCurrentSeason(QueryPointsBoardCmd cmd) throws ExecutionException, InterruptedException {
        log.info("查询当前赛季");
        // 获取用户当前积分排行榜信息
        CompletableFuture<PointsBoardEntity> userPointsBoardCompletableFuture = CompletableFuture.supplyAsync(
                () -> boardDomainService.queryUserCurrentPointsBoard(cmd.getUserId()));

        // 获取排行榜信息
        CompletableFuture<List<PointsBoardEntity>> listCompletableFuture = CompletableFuture.supplyAsync(
                () -> boardDomainService.queryCurrentPointsBoardList(cmd.getPointsBoardQuery()));

        // 获取积分排行榜
        CompletableFuture<Map<Long, UserDetailEntity>> mapCompletableFuture = listCompletableFuture.thenApply(pointsBoardEntities -> {
            Set<Long> userIds = pointsBoardEntities.stream()
                    .map(PointsBoardEntity::getUserId)
                    .collect(Collectors.toSet());

            return userDetailDomainService.getMapEntities(userIds);
        });

        // 等待所有CompletableFuture完成
        CompletableFuture<Void> all = CompletableFuture.allOf(userPointsBoardCompletableFuture, listCompletableFuture, mapCompletableFuture);

        // 封装结果
        return all.thenApply(v -> {
            try {
                PointsBoardVo vo = new PointsBoardVo();

                PointsBoardEntity userPointsBoard = userPointsBoardCompletableFuture.get();
                List<PointsBoardEntity> pointsBoardEntities = listCompletableFuture.get();
                Map<Long, UserDetailEntity> userMap = mapCompletableFuture.get();
                return handleResult(pointsBoardEntities, userPointsBoard, userMap);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).get();
    }

    /**
     * 处理历史赛季
     */
    private PointsBoardVo handleHistorySeason(QueryPointsBoardCmd cmd) {
        log.info("查询历史赛季");
        PointsBoardVo vo = new PointsBoardVo();

        return vo;
    }


    /**
     * 封装结果
     *
     * @param pointsBoard     积分排行榜
     * @param userPointsBoard 用户积分排行榜
     * @param usersMap        用户信息
     * @return 结果
     */
    private PointsBoardVo handleResult(List<PointsBoardEntity> pointsBoard,
                                       PointsBoardEntity userPointsBoard,
                                       Map<Long, UserDetailEntity> usersMap) {
        PointsBoardVo vo = new PointsBoardVo();
        vo.setPoints(userPointsBoard.getPoints());
        vo.setRank(userPointsBoard.getRank());

        List<PointsBoardItemVo> boardList = new ArrayList<>();
        for (PointsBoardEntity entity : pointsBoard) {
            PointsBoardItemVo itemVo = new PointsBoardItemVo();

            UserDetailEntity userDetailEntity = usersMap.get(entity.getUserId());
            if (userDetailEntity != null) {
                itemVo.setUserName(userDetailEntity.getName());
            }

            itemVo.setPoints(entity.getPoints());
            itemVo.setRank(entity.getRank());
            boardList.add(itemVo);
        }

        vo.setBoardList(boardList);
        return vo;
    }


}
