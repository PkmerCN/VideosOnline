package org.hzz.core.enums;

/**
 * 抽象BaseEnum模版
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
public abstract class BaseEnumTemplate{

    /**
     * 处理Byte对应的枚举
     * @param enumClass 枚举类型
     * @param value value
     * @return 枚举
     * @param <T> 枚举类型
     */
    public static <T extends Enum<T> & BaseEnum> T fromByteValue(Class<T> enumClass, Byte value) {
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

    /**
     * 处理Integer对应的枚举
     * @param enumClass 枚举类型
     * @param value value
     * @return 枚举
     * @param <T> 枚举类型
     */
    public static <T extends Enum<T> & BaseEnum> T fromIntValue(Class<T> enumClass, Integer value) {
        if(value == null){
            return null;
        }

        for (T type: enumClass.getEnumConstants()){
            if(type.getValue().equals(value)){
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + "in " + enumClass.getSimpleName());
    }
}
