package org.hzz.core.enums;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public interface BaseEnum {
    abstract Integer getValue();
    abstract String getDesc();

    default boolean equalsValue(Integer value){
        if(value == null) return false;
        return getValue().equals(value);
    }
}
