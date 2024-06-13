package org.hzz.mapstruct;

import org.hzz.domain.bo.UserBo;
import org.hzz.domain.entity.AppUser;
import org.mapstruct.Mapper;

/**
 * 将数据库的Entity映射为业务对象
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/14
 */
@Mapper(componentModel = "spring")
public abstract class AppUserEntityToBo {
    public abstract UserBo mapAppUserToUserBo(AppUser appUser);
}
