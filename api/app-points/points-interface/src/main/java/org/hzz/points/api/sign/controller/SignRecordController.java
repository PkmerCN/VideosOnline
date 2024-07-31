package org.hzz.points.api.sign.controller;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.points.api.sign.SignRecordApi;
import org.hzz.points.application.command.sign.AddSignRecordCmd;
import org.hzz.points.application.command.sign.QuerySignRecordsCmd;
import org.hzz.points.application.service.PointsCmdService;
import org.hzz.points.types.resp.SignResultVo;
import org.hzz.security.context.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@RestController
public class SignRecordController
        extends BaseController
        implements SignRecordApi {

    @Setter(onMethod_ = @Autowired)
    private PointsCmdService cmdService;

    @Override
    public Result<SignResultVo> addSignRecord() {
        logger.info("签到");
        AddSignRecordCmd cmd = new AddSignRecordCmd();
        cmd.setUserId(AppContextHolder.userContextHolder.getUser().getId());
        SignResultVo vo = cmdService.<SignResultVo>handleCommandWithResult(cmd);
        return success(vo);
    }

    @Override
    public Result<int[]> querySignRecords() {
        logger.info("查询用户签到记录");
        QuerySignRecordsCmd cmd = QuerySignRecordsCmd.commandOf(
                AppContextHolder.userContextHolder.getUser().getId()
        );
        int[] signRecords = cmdService.<int[]>handleCommandWithResult(cmd);
        return success(signRecords);
    }
}
