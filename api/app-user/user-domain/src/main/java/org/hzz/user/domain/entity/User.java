package org.hzz.user.domain.entity;

import io.gitee.pkmer.ddd.shared.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Entity {
    private Long id;
    private String username;
    private String cellPhone;
    private String password;
    private String email;
}
