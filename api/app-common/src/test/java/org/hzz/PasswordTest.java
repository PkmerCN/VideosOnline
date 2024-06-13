package org.hzz;

import org.hzz.utils.AppPasswordEncoder;
import org.hzz.utils.BcryptPassword4j;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */
public class PasswordTest {
    private AppPasswordEncoder passwordEncoder;
    @Before
    public void before(){
        passwordEncoder = new BcryptPassword4j();
    }

    @Test
    public void test(){
        String rawPassword = "Root.12345";
        String encodePassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodePassword);
        boolean checkResult = passwordEncoder.check(rawPassword, encodePassword);
        assertTrue(checkResult);
    }
}
