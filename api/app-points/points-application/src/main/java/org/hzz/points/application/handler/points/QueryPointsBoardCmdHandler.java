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
     * {
     * "code": 2000,
     * "msg": "成功",
     * "data": {
     * "boardList": [
     * {
     * "points": 20,
     * "rank": 1,
     * "userName": "胖卡"
     * },
     * {
     * "points": 10,
     * "rank": 2,
     * "userName": "pkmer"
     * },
     * {
     * "points": 1,
     * "rank": 3,
     * "userName": "壮哥"
     * }
     * ],
     * "points": 1,
     * "rank": 3
     * }
     * }
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

        return handleCompletableFuture(userPointsBoardCompletableFuture, listCompletableFuture);
    }

    /**
     * 处理历史赛季
     */
    private PointsBoardVo handleHistorySeason(QueryPointsBoardCmd cmd) throws ExecutionException, InterruptedException {
        Integer seasonId = cmd.getPointsBoardQuery().getSeasonId();
        log.info("查询历史{}赛季", seasonId);
        // 获取用户当前积分排行榜信息
        CompletableFuture<PointsBoardEntity> userPointsBoardCompletableFuture = CompletableFuture.supplyAsync(
                () -> boardDomainService.queryUserHistoryPointsBoard(seasonId, cmd.getUserId()));

        // 获取排行榜信息
        CompletableFuture<List<PointsBoardEntity>> listCompletableFuture = CompletableFuture.supplyAsync(
                () -> boardDomainService.queryHistoryPointsBoardList(seasonId, cmd.getPointsBoardQuery()));

        return handleCompletableFuture(userPointsBoardCompletableFuture, listCompletableFuture);
    }


    /**
     * 处理所有相关completableFuture
     *
     * @param currentUserPointBoardCompletableFuture 当前用户的积分排行
     * @param allPointsBoardCompletableFuture        所有用户的积分排行
     * @return 封装的结果
     * @throws ExecutionException
     * @throws InterruptedException
     */
    private PointsBoardVo handleCompletableFuture(
            CompletableFuture<PointsBoardEntity> currentUserPointBoardCompletableFuture,
            CompletableFuture<List<PointsBoardEntity>> allPointsBoardCompletableFuture) throws ExecutionException, InterruptedException {

        // 获取所有用户信息
        CompletableFuture<Map<Long, UserDetailEntity>> mapCompletableFuture = allPointsBoardCompletableFuture.thenApply(pointsBoardEntities -> {
            Set<Long> userIds = pointsBoardEntities.stream()
                    .map(PointsBoardEntity::getUserId)
                    .collect(Collectors.toSet());

            return userDetailDomainService.getMapEntities(userIds);
        });

        // 等待所有CompletableFuture完成
        CompletableFuture<Void> all = CompletableFuture.allOf(currentUserPointBoardCompletableFuture, allPointsBoardCompletableFuture, mapCompletableFuture);

        // 封装结果
        return all.thenApply(v -> {
            try {
                PointsBoardEntity userPointsBoard = currentUserPointBoardCompletableFuture.get();
                List<PointsBoardEntity> pointsBoardEntities = allPointsBoardCompletableFuture.get();
                Map<Long, UserDetailEntity> userMap = mapCompletableFuture.get();

                return handleResult(pointsBoardEntities, userPointsBoard, userMap);
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }).get();
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
