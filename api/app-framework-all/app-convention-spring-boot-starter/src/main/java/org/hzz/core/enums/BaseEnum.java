package org.hzz.core.enums;

/**
 * 用于mvc 反序列化和序列化
 * {@link org.hzz.fastjson2.enums.BaseEnumReader}
 * {@link org.hzz.fastjson2.enums.BaseEnumWriter}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public interface BaseEnum<T> {
    abstract T getValue();
    abstract String getDesc();

    default boolean equalsValue(T value){
        if(value == null) return false;
        return getValue().equals(value);
    }
}
