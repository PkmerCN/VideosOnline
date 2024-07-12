package org.hzz.user.domain.service.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.user.domain.exception.EmailException;
import org.hzz.user.domain.entity.User;
import org.hzz.user.domain.repository.UserRepository;
import org.hzz.user.domain.service.UserDomainService;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
@Service
public class UserDomainServiceImpl extends BaseDomainService<UserRepository> implements UserDomainService {
    @Override
    public User getUserByEmailAndPassword(String email) {
        User user = repository.findUserByEmailAndPassword(email);
        return Optional.ofNullable(user).orElseThrow(EmailException::new);
    }
}
