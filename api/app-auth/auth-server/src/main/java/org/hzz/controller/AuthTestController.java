package org.hzz.controller;


import org.hzz.context.AppContextHolder;
import org.hzz.domain.user.bo.UserBo;
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
        UserBo user = AppContextHolder.userContextHolder.getUser();
        return user.getEmail()+"This is a Test at "+ LocalDate.now();
    }
}
