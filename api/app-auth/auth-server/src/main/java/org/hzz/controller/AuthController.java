package org.hzz.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.hzz.domain.dto.LoginUserDto;
import org.hzz.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 认证处理
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/28
 */
@Tag(name = "用户认证",description = "用户的登录注册等")
@RestController("/auth")
@Slf4j
public class AuthController {

    @Autowired
    private JWTService jwtService;

    @Operation(summary = "用户注册",description = "用户登录生成token")
    @PostMapping("login")
    public void login(@RequestBody LoginUserDto loginUserDto){
        log.info(" email = {} password = {}",loginUserDto.getEmail(),loginUserDto.getPassword());
    }

    @GetMapping("/auth")
    public String hello(){
        throw new RuntimeException("auth error");
//        return "hello auth demo success04";
    }

    @GetMapping("/user")
    public String user(){
        return "胖卡666777";
    }
}
