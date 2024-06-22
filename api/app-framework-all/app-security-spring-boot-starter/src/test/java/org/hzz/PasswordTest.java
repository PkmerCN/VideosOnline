package org.hzz;

import org.hzz.security.password.AppPasswordEncoder;
import org.hzz.security.password.BcryptPassword4j;
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
        String rawPassword = "Root.123456";
        String encodePassword = passwordEncoder.encode(rawPassword);
        System.out.println(encodePassword);
        boolean checkResult = passwordEncoder.check(rawPassword, "$2b$10$v54tBm6hSleOidxLJvznju9KZkBgv6IubYoGwKvyrUd84Nb7aLTpK");
        assertTrue(checkResult);
    }

    @Test
    public void testMultiEncodePassword(){
        String rawPassword = "Root.123456";
        String encodePasswords[] = {
                "$2b$10$gFC0Wkt6.JGL4TL4MQiaMOy5VlLkZ6onbPy1YOtIJOKtb4NSIpChO",
                "$2b$10$v54tBm6hSleOidxLJvznju9KZkBgv6IubYoGwKvyrUd84Nb7aLTpK",
                "$2b$10$65BW4vfYqHkS3elSPFyj6OFBzQm5OCOqMygcGTFPp5OrANsv0NuNO"
        };

        for (String encodePassword: encodePasswords) {
            boolean checkResult = passwordEncoder.check(rawPassword, "$2b$10$v54tBm6hSleOidxLJvznju9KZkBgv6IubYoGwKvyrUd84Nb7aLTpK");
            System.out.println(checkResult);
            assertTrue(checkResult);
        }

    }
}
