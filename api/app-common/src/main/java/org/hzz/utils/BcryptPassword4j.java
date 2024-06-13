package org.hzz.utils;

import com.password4j.BcryptFunction;
import com.password4j.Password;
import com.password4j.types.Bcrypt;

/**
 * https://github.com/Password4j/password4j/wiki/BCrypt
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */
public class BcryptPassword4j implements AppPasswordEncoder {
    private BcryptFunction myBcrypt;
    public BcryptPassword4j(){
        myBcrypt = BcryptFunction.getInstance(Bcrypt.B, 10);
    }

    @Override
    public String encode(CharSequence userProvidedPassword) {
        return Password.hash(userProvidedPassword)
                .with(myBcrypt).getResult();
    }

    @Override
    public boolean check(CharSequence userProvidedPassword, String encodedPassword) {
        return Password.check(userProvidedPassword,encodedPassword).with(myBcrypt);
    }
}
