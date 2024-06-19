package org.hzz.user.domain.repository;

import org.hzz.user.infrastructure.dao.entity.AppUser;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
public interface UserRepository {

    AppUser findUserByEmailAndPassword(String email,String password);
}
