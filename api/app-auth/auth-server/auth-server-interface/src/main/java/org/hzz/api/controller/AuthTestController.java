package org.hzz.api.controller;


import org.hzz.security.context.AppContextHolder;
import org.hzz.security.jwt.bo.JWTUserBo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/18
 */

@RestController
@RequestMapping("/auth-test")
public class AuthTestController {

    @GetMapping
    public String authTest(){
        JWTUserBo user = AppContextHolder.userContextHolder.getUser();
        return user.getEmail()+" This is a Test at "+ LocalDate.now();
    }
}
