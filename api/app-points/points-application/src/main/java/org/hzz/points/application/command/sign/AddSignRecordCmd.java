package org.hzz.points.application.command.sign;

import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.points.application.handler.sign.AddSignRecordCmdHandler;

/**
 * 添加积分
 * {@link AddSignRecordCmdHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
public class AddSignRecordCmd implements CommandWithMark {
    public static final String MARK = AddSignRecordCmd.class.getName();
    @Override
    public String mark() {
        return MARK;
    }
}
