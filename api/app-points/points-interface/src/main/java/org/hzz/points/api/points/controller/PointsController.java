package org.hzz.points.api.points.controller;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.points.api.points.PointsApi;
import org.hzz.points.application.command.points.QueryUserPointsCmd;
import org.hzz.points.application.service.PointsCmdService;
import org.hzz.points.types.resp.PointsStatisticsVo;
import org.hzz.security.context.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}