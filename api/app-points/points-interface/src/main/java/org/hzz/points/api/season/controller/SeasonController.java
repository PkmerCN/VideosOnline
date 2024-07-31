package org.hzz.points.api.season.controller;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.points.api.season.SeasonApi;
import org.hzz.points.application.command.points.GetAllSeasonCmd;
import org.hzz.points.application.service.PointsCmdService;
import org.hzz.points.types.resp.SeasonVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@RestController
public class SeasonController
        extends BaseController
        implements SeasonApi {

    @Setter(onMethod_ = @Autowired)
    private PointsCmdService cmdService;

    @Override
    public Result<List<SeasonVo>> getAllSeason() {
        logger.info("获取全部赛季列表");
        List<SeasonVo> seasonVos = cmdService.<List<SeasonVo>>handleCommandWithResult(
                GetAllSeasonCmd.commandOf());

        return success(seasonVos);
    }
}
