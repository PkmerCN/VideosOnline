package org.hzz.security.password;

/**
 * 密码加密与校验
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/21
 */
public interface AppPasswordEncoder {
    String encode(CharSequence userProvidedPassword);
    boolean check(CharSequence userProvidedPassword,String encodedPassword);
}
