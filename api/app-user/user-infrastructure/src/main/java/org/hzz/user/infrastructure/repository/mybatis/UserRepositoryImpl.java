package org.hzz.user.infrastructure.repository.mybatis;

import org.hzz.core.repository.BaseRepository;
import org.hzz.user.domain.model.User;
import org.hzz.user.domain.repository.UserRepository;
import org.hzz.user.infrastructure.converter.UserConverter;
import org.hzz.user.infrastructure.dao.entity.AppUser;
import org.hzz.user.infrastructure.dao.entity.AppUserExample;
import org.hzz.user.infrastructure.dao.mapper.AppUserMapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户repository实现
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
@Repository
public class UserRepositoryImpl extends BaseRepository<AppUserMapper, UserConverter> implements UserRepository {

    @Override
    public User findUserByEmailAndPassword(String email) {
        AppUserExample appUserExample = new AppUserExample();
        appUserExample.createCriteria()
                .andEmailEqualTo(email);

        // todo 如果不存在会返回什么
        List<AppUser> appUsers = mapper.selectByExample(appUserExample);
        return converter.doToUser(appUsers.get(0));
    }
}
