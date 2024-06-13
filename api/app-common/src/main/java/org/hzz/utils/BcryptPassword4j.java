package org.hzz.utils;

import com.password4j.Password;

/**
 * https://github.com/Password4j/password4j/wiki/BCrypt
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */
public class BcryptPassword4j implements AppPasswordEncoder {
    @Override
    public String encode(CharSequence userProvidedPassword) {
        return Password.hash(userProvidedPassword).withBcrypt().getResult();
    }

    @Override
    public boolean check(CharSequence userProvidedPassword, String encodedPassword) {
        return Password.check(userProvidedPassword,encodedPassword).withBcrypt();
    }
}
