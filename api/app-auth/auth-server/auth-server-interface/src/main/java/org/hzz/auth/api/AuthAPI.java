package org.hzz.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.api.model.LoginUserRequest;
import org.hzz.core.result.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 认证处理
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Tag(name = "用户认证", description = "用户的登录注册等")
@RequestMapping("/auth")
public interface AuthAPI {

    @Operation(summary = "用户登录", description = "用户登录生成token")
    @PostMapping("/login")
    public Result<Object> login(@Valid @RequestBody LoginUserRequest loginUserRequest);

}
