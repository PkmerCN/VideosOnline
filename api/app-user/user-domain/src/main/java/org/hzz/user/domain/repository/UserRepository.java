package org.hzz.user.domain.repository;

import org.hzz.user.domain.entity.User;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
public interface UserRepository {

    User findUserByEmailAndPassword(String email);
}
