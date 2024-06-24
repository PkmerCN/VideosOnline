package org.hzz.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Tag(name = "Auth Test", description = "auth 测试")
@RequestMapping("/auth-test")
public interface AuthTestAPI {
    @Operation(summary = "获取登录的用户",
            description = "获取登录的用户信息,用户必须先登录，获取token,才能使用接口")
    @GetMapping("/user")
    String authTest();

    @Operation(summary = "测试内部错误",
            description = "测试服务内部错误")
    @GetMapping("/error")
    String error();

    @Operation(summary = "简单测试",
            description = "测试Auth 接口是否可用")
    @GetMapping("/test")
    public String test();
}
