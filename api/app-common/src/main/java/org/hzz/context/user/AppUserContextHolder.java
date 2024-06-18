package org.hzz.context.user;

import org.hzz.context.AppCommonContextHolder;
import org.hzz.domain.user.bo.UserBo;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/18
 */
public class AppUserContextHolder extends AppCommonContextHolder<UserBo> {

    public AppUserContextHolder() {
        super();
    }

    public void setUser(UserBo user) {
        setObject(user);
    }

    public UserBo getUser() {
        return getObject();
    }

    @Override
    public String getContextName() {
        return "app_user_context";
    }
}
