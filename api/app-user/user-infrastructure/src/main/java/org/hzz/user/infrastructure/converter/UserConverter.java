package org.hzz.user.infrastructure.converter;

import org.hzz.user.domain.entity.User;
import org.hzz.user.infrastructure.dao.entity.AppUser;
import org.mapstruct.Mapper;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
@Mapper(componentModel = "spring")
public interface UserConverter{
    User doToUser(AppUser user);
}
