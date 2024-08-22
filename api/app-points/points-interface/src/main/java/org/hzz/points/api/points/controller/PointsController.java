package org.hzz.points.api.points.controller;

import lombok.Setter;
import io.gitee.pkmer.convention.controller.BaseController;
import io.gitee.pkmer.convention.exception.request.BadRequestException;
import io.gitee.pkmer.convention.result.Result;
import org.hzz.points.api.points.PointsApi;
import org.hzz.points.application.command.points.QueryPointsBoardCmd;
import org.hzz.points.application.command.points.QueryUserPointsCmd;
import org.hzz.points.application.service.PointsCmdService;
import org.hzz.points.types.req.PointsBoardQuery;
import org.hzz.points.types.resp.PointsBoardVo;
import org.hzz.points.types.resp.PointsStatisticsVo;
import io.gitee.pkmer.security.context.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static io.gitee.pkmer.convention.code.impl.AppStatusImpl.NOT_ALLOW_100;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@RestController
public class PointsController
        extends BaseController
        implements PointsApi {

    @Setter(onMethod_ = @Autowired)
    private PointsCmdService cmdService;

    @Override
    public Result<List<PointsStatisticsVo>> queryUserPointsForToday() {
        logger.info("获取用户今日积分情况");
        QueryUserPointsCmd cmd = QueryUserPointsCmd.commandOf(
                AppContextHolder.userContextHolder.getUser().getId()
        );
        List<PointsStatisticsVo> vos = cmdService.<List<PointsStatisticsVo>>handleCommandWithResult(cmd);
        return success(vos);
    }

    @Override
    public Result<PointsBoardVo> queryPointsBoardBySeason(PointsBoardQuery query) {
        logger.info("查询赛季排行榜");
        if(query.isMoreThen100()){
            logger.info("只允许查询一百条");
            throw new BadRequestException(NOT_ALLOW_100);
        }

        QueryPointsBoardCmd cmd = QueryPointsBoardCmd.commandOf(
                AppContextHolder.userContextHolder.getUser().getId(),
                query
        );

        PointsBoardVo vo = cmdService.<PointsBoardVo>handleCommandWithResult(cmd);
        return success(vo);
    }
}
