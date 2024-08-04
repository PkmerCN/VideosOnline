package org.hzz.common.util;

import java.lang.reflect.Field;

/**
 * 封装反射的知识
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
public class ReflectionUtils {

    public static void setField(Object target, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(target, value);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static  void setField(Object target, String fieldName, Object value) {
        try {
            Field field = target.getClass().getDeclaredField(fieldName);
            setField(target,field,value);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

}
