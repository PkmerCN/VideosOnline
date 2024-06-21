package org.hzz.user.application.service.impl;


import org.hzz.designpattern.strategy.StrategyChoose;
import org.hzz.user.application.resp.UserLoginRespDTO;
import org.hzz.user.application.service.UserAppService;
import org.hzz.user.application.command.UserLoginCommand;
import org.hzz.user.domain.common.UserLoginTypeEnum;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
@Service
public class UserAppServiceImpl implements UserAppService {
    private final StrategyChoose strategyChoose;
    public UserAppServiceImpl(StrategyChoose strategyChoose){
        this.strategyChoose = strategyChoose;
    }
    @Override
    public UserLoginRespDTO login(UserLoginCommand command) {
        return strategyChoose.<UserLoginCommand, UserLoginRespDTO>chooseAndExecuteWithResp(
                UserLoginTypeEnum.USER_LOGIN_MAIL.toString(),
                command);
    }
}
