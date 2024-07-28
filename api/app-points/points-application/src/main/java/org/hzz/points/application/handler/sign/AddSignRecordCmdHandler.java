package org.hzz.points.application.handler.sign;

import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.points.application.command.sign.AddSignRecordCmd;
import org.hzz.points.types.resp.SignResultVo;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@Component
public class AddSignRecordCmdHandler
        implements AbstractExecuteStrategy<AddSignRecordCmd, SignResultVo> {
    @Override
    public String mark() {
        return AddSignRecordCmd.MARK;
    }

    @Override
    public SignResultVo executeWithResp(AddSignRecordCmd cmd) {
        return null;
    }
}
