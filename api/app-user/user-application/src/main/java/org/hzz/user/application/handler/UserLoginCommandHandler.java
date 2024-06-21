package org.hzz.user.application.handler;

import org.hzz.ddd.core.domain.shared.CommandHandler;
import org.hzz.designpattern.strategy.AbstractExecuteStrategy;
import org.hzz.user.application.command.UserLoginCommand;
import org.hzz.user.application.resp.UserLoginRespDTO;

/**
 * 主要做command的转发
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
public class UserLoginCommandHandler implements CommandHandler, AbstractExecuteStrategy<UserLoginCommand, UserLoginRespDTO> {
    @Override
    public String mark() {
        return null;
    }
}
