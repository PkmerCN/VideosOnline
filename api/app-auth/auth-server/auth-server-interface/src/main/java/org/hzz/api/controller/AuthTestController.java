package org.hzz.api.controller;


import org.hzz.api.AuthTestAPI;
import org.hzz.core.controller.BaseController;
import org.hzz.core.exception.AppCommonException;
import org.hzz.security.context.AppContextHolder;
import org.hzz.security.jwt.bo.JWTUserBo;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/18
 */

@RestController
public class AuthTestController extends BaseController implements AuthTestAPI {

    @Override
    public String authTest(){
        logger.info("测试用户的登录信息");
        JWTUserBo user = AppContextHolder.userContextHolder.getUser();
        return user.getEmail()+" This is a Test at "+ LocalDate.now();
    }

    @Override
    public String error() {
        logger.info("测试服务内部错误");
        throw new AppCommonException();
    }

    @Override
    public String test() {
        logger.info("简单测试");
        return "This is a test";
    }
}
