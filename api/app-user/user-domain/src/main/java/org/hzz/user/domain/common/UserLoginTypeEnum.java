package org.hzz.user.domain.common;

/**
 * 用户登录枚举
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/21
 */
public enum UserLoginTypeEnum {
    /**
     * 邮箱验证码登录
     */
    USER_LOGIN_MAIL,

    /**
     * 账号密码登录
     */
    USER_LOGIN_ACCOUNT;

    @Override
    public String toString() {
        return this.name();
    }
}
