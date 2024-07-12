package org.hzz.user.domain.service;

import org.hzz.user.domain.entity.User;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public interface UserDomainService {

    User getUserByEmailAndPassword(String email);
}
