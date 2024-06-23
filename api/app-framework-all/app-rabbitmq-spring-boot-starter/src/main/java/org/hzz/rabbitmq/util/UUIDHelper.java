package org.hzz.rabbitmq.util;

import java.util.UUID;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/23
 */
public class UUIDHelper {

    public static String generateUUID(){
        return UUID.randomUUID().toString();
    }
}
