package org.hzz.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/12
 */
@Data
public class LoginUserDto {
    @Schema(description = "邮箱",example = "1193094618@qq.com")
    @NotNull
    private String email;
    @Schema(description = "密码",example = "Root.123456")
    @NotNull
    private String password;
}
