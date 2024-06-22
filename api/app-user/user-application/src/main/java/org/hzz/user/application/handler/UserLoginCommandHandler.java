package org.hzz.user.application.handler;

import org.hzz.ddd.core.domain.shared.CommandHandler;
import org.hzz.designpattern.strategy.AbstractExecuteStrategy;
import org.hzz.user.application.command.UserLoginCommand;
import org.hzz.user.application.resp.UserLoginRespDTO;
import org.hzz.user.domain.common.UserLoginTypeEnum;
import org.hzz.user.domain.model.User;
import org.hzz.user.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 主要做command的转发
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
@Service
public class UserLoginCommandHandler implements CommandHandler, AbstractExecuteStrategy<UserLoginCommand, UserLoginRespDTO> {
    @Autowired
    private UserDomainService userDomainService;

    @Override
    public String mark() {
        return UserLoginTypeEnum.USER_LOGIN_MAIL.toString();
    }

    @Override
    public UserLoginRespDTO executeWithResp(UserLoginCommand command) {
        User user = userDomainService.getUserByEmailAndPassword(command.getEmail());
        // todo 转换
        return null;
    }
}
