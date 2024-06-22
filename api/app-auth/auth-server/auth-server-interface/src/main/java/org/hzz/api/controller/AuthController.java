package org.hzz.api.controller;

import org.hzz.api.AuthAPI;
import org.hzz.api.model.LoginUserRequest;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.user.application.command.UserLoginCommand;
import org.hzz.user.application.service.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@RestController
public class AuthController extends BaseController implements AuthAPI {
    @Autowired
    private UserAppService userAppService;
    @Override
    public Result<Object> login(LoginUserRequest loginUserRequest) {
        UserLoginCommand userLoginCommand = UserLoginCommand.commandOf(loginUserRequest.getEmail(), loginUserRequest.getPassword());
        userAppService.login(userLoginCommand);
        return null;
    }
}
