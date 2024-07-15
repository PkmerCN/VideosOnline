package org.hzz.core.enums;

/**
 * 抽象BaseEnum模版
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
public abstract class BaseEnumTemplate{
    public static <T extends Enum<T> & BaseEnum> T fromValue(Class<T> enumClass, Byte value) {
        if(value == null){
            return null;
        }

        for (T type: enumClass.getEnumConstants()){
            if(type.getValue().equals(value.intValue())){
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + "in " + enumClass.getSimpleName());
    }
}
