package org.hzz.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/28
 */
@RestController
public class AuthController {

    @GetMapping("/auth")
    public String hello(){
        return "hello auth demo success04";
    }

    @GetMapping("/user")
    public String user(){
        return "胖卡666";
    }
}
