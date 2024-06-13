package org.hzz.domain.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/2
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserBo {
    private Long id;
    private String username;
    private String cellPhone;
    private String password;
    private String email;
}
