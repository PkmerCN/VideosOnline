package org.hzz.auth;

import org.hzz.auth.command.UserLoginCommand;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Service
public class AuthAppService {
//    @Autowired
//    private StrategyChoose strategyChoose;

    /**
     * 登录
     * @param command
     * @return 返回对应的token
     */
    public String login(UserLoginCommand command){
//        return strategyChoose.chooseAndExecuteWithResp(
//                UserLoginTypeEnum.USER_LOGIN_MAIL.toString(),
//                command);
        return "";
    }
}
