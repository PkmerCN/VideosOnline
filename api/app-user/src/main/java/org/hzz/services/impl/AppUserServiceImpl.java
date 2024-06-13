package org.hzz.services.impl;

import org.hzz.domain.bo.UserBo;
import org.hzz.domain.entity.AppUser;
import org.hzz.domain.entity.AppUserExample;
import org.hzz.mapper.AppUserMapper;
import org.hzz.mapstruct.AppUserEntityToBo;
import org.hzz.services.AppUserService;
import org.hzz.utils.AppPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */
@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppPasswordEncoder appPasswordEncoder;

    @Autowired
    private AppUserMapper appUserMapper;

    @Autowired
    private AppUserEntityToBo appUserEntityToBo;

    @Override
    public UserBo getUserByEmailAndPassword(String email, String password) {


        AppUserExample appUserExample = new AppUserExample();
        appUserExample.createCriteria()
                .andEmailEqualTo(email);

        List<AppUser> appUsers = appUserMapper.selectByExample(appUserExample);

        if(appUsers == null || appUsers.size() == 0){
            throw new RuntimeException("邮箱不存在");
        }
        AppUser appUser = appUsers.get(0);
        // 校验密码
        if(!appPasswordEncoder.check(password,appUser.getPassword())){
            throw new RuntimeException("密码不正确");
        }
        return appUserEntityToBo.mapAppUserToUserBo(appUser);
    }
}
