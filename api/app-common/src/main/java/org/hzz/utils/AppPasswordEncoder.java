package org.hzz.utils;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */
public interface AppPasswordEncoder {
    String encode(CharSequence userProvidedPassword);
    boolean check(CharSequence userProvidedPassword,String encodedPassword);
}
