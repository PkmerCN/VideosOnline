package org.hzz.api.controller;

import lombok.Setter;
import org.hzz.auth.AuthAppService;
import org.hzz.api.AuthAPI;
import org.hzz.api.model.LoginUserRequest;
import org.hzz.auth.command.UserLoginCommand;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@RestController
public class AuthController extends BaseController implements AuthAPI {
    @Setter(onMethod_ = @Autowired)
    private AuthAppService authAppService;

    @Override
    public Result<Object> login(LoginUserRequest loginUserRequest) {
        final String email = loginUserRequest.getEmail();
        final String password = loginUserRequest.getPassword();
        logger.info("用户登录 email = {} , password = {}",email,password);

        UserLoginCommand userLoginCommand = UserLoginCommand.commandOf(email,password);
        String token = authAppService.login(userLoginCommand);
        Map<String,Object> body = Map.of("token",token);
        return success(body);
    }
}
