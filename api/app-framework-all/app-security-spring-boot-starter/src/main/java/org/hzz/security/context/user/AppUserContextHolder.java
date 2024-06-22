package org.hzz.security.context.user;

import org.hzz.security.context.AppCommonContextHolder;
import org.hzz.security.jwt.bo.JWTUserBo;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
public class AppUserContextHolder extends AppCommonContextHolder<JWTUserBo> {
    public AppUserContextHolder(){
        super();
    }

    public void setUser(JWTUserBo user) {
        setObject(user);
    }

    public JWTUserBo getUser() {
        return getObject();
    }
    @Override
    public String getContextName() {
        return "app_user_context";
    }
}
