package org.hzz.user.infrastructure.repository.impl;

import org.hzz.user.infrastructure.dao.entity.AppUser;
import org.hzz.user.infrastructure.dao.entity.AppUserExample;
import org.hzz.user.infrastructure.dao.mapper.AppUserMapper;
import org.hzz.user.infrastructure.repository.UserRepository;
import org.hzz.user.infrastructure.repository.BaseRepository;

import java.util.List;

/**
 * 用户repository实现
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
public class UserRepositoryImpl extends BaseRepository<AppUserMapper> implements UserRepository {

    @Override
    public AppUser findUserByEmailAndPassword(String email,String password) {
        AppUserExample appUserExample = new AppUserExample();
        appUserExample.createCriteria()
                .andEmailEqualTo(email);

        // todo 如果不存在会返回什么
        List<AppUser> appUsers = mapper.selectByExample(appUserExample);
        return appUsers.get(0);
    }
}
