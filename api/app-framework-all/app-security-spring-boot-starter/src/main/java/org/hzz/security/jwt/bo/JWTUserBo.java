package org.hzz.security.jwt.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JWTUserBo {
    private Long id;
    private String username;
    private String cellPhone;
    private String password;
    private String email;
}
