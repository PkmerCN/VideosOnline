package org.hzz.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.hzz.domain.app.Result;
import org.hzz.domain.bo.UserBo;
import org.hzz.domain.dto.LoginUserDto;
import org.hzz.services.AppUserService;
import org.hzz.services.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 认证处理
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/28
 */
@Tag(name = "用户认证", description = "用户的登录注册等")
@Slf4j
@Validated
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AppUserService appUserService;


    @Operation(summary = "用户登录", description = "用户登录生成token")
    @PostMapping("login")
    public Result<Map<String, String>> login(@Valid @RequestBody LoginUserDto loginUserDto) {
        UserBo user = appUserService.getUserByEmailAndPassword(loginUserDto.getEmail(),
                loginUserDto.getPassword());
        String token = jwtService.generateToken(user);
        Map<String, String> data = Map.of("token", token);
        return Result.success(data);
    }

    @GetMapping("/auth")
    public String hello() {
        throw new RuntimeException("auth error");
//        return "hello auth demo success04";
    }

    @GetMapping("/test")
    public String user() {
        return "This is a test";
    }
}
