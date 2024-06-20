package org.hzz.user.domain.service.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.user.domain.model.User;
import org.hzz.user.domain.repository.UserRepository;
import org.hzz.user.domain.service.UserDomainService;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
@Service
public class UserDomainServiceImpl extends BaseDomainService<UserRepository> implements UserDomainService {
    @Override
    public User login(String email, String password) {
        logger.info("");
        return null;
    }
}
