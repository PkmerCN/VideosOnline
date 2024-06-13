package org.hzz.services;

import org.hzz.domain.bo.UserBo;
import org.hzz.domain.entity.AppUser;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */
public interface AppUserService {
    UserBo getUserByEmailAndPassword(String email, String password);
}
