package org.hzz.user.domain.repository;

import org.hzz.user.domain.model.User;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
public interface UserRepository {

    User findUserByEmailAndPassword(String email, String password);
}
