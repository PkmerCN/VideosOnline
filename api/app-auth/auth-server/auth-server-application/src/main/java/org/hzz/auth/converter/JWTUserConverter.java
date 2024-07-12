package org.hzz.auth.converter;

import org.hzz.security.jwt.bo.JWTUserBo;
import org.hzz.user.domain.entity.User;
import org.mapstruct.Mapper;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Mapper(componentModel = "spring")
public interface JWTUserConverter {

    JWTUserBo toJWTUser(User user);
}
