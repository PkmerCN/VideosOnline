package org.hzz.auth.handler;

import lombok.Setter;
import org.hzz.auth.command.UserLoginCommand;
import org.hzz.auth.converter.JWTUserConverter;
import org.hzz.auth.exception.PasswordException;
import io.gitee.pkmer.ddd.shared.command.CommandHandler;
import io.gitee.pkmer.designpattern.strategy.AbstractExecuteStrategy;
import io.gitee.pkmer.security.jwt.bo.JWTUserBo;
import io.gitee.pkmer.security.jwt.service.JWTService;
import io.gitee.pkmer.security.password.AppPasswordEncoder;
import org.hzz.user.domain.common.UserLoginTypeEnum;
import org.hzz.user.domain.entity.User;
import org.hzz.user.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 用户登录handler
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/23
 */
@Component
public class UserLoginCommandHandler implements CommandHandler, AbstractExecuteStrategy<UserLoginCommand,String> {
    @Setter(onMethod_ = @Autowired)
    private JWTService jwtService;

    @Setter(onMethod_ = @Autowired)
    private AppPasswordEncoder appPasswordEncoder;

    @Setter(onMethod_ = @Autowired)
    private UserDomainService userDomainService;

    @Setter(onMethod_ = @Autowired)
    private JWTUserConverter jwtUserConverter;

    @Override
    public String mark() {
        return UserLoginTypeEnum.USER_LOGIN_MAIL.toString();
    }


    public String executeWithResp(UserLoginCommand command) {
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
