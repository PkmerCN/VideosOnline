package org.hzz.auth;

import org.hzz.auth.command.UserLoginCommand;
import org.hzz.auth.converter.JWTUserConverter;
import org.hzz.auth.exception.PasswordException;
import org.hzz.security.jwt.bo.JWTUserBo;
import org.hzz.security.jwt.service.JWTService;
import org.hzz.security.password.AppPasswordEncoder;
import org.hzz.user.domain.model.User;
import org.hzz.user.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Service
public class AuthAppService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AppPasswordEncoder appPasswordEncoder;

    @Autowired
    private UserDomainService userDomainService;

    @Autowired
    private JWTUserConverter jwtUserConverter;

    /**
     * 登录
     * @param command
     * @return 返回对应的token
     */
    public String login(UserLoginCommand command){
        User user = userDomainService.getUserByEmailAndPassword(command.getEmail());
        // 校验密码
        if(!appPasswordEncoder.check(command.getPassword(),user.getPassword())){
            throw new PasswordException();
        }

        return generateToken(jwtUserConverter.toJWTUser(user));
    }

    /**
     * 生成token
     * @param jwtUserBo
     * @return
     */
    private String generateToken(JWTUserBo jwtUserBo){
        return jwtService.generateToken(jwtUserBo);
    }
}
