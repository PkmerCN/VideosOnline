package org.hzz.fastjson2.enums;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReader;
import org.hzz.core.enums.BaseEnum;

import java.lang.reflect.Type;

/**
 * 转为BaseEnum枚举
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@SuppressWarnings("rawtypes")
public class BaseEnumReader implements ObjectReader {
    /**
     * 读取json中的status字段，转换为枚举类型
     * @param jsonReader
     * @param fieldType 比如：class org.hzz.enumm.HttpStatus
     * @param fieldName 比如：status
     * @param features 一个标识位 6755399441055744
     * @return
     */
    @Override
    public Object readObject(JSONReader jsonReader, Type fieldType, Object fieldName, long features) {
        // 读取json中的status字段，转换为枚举类型
        Integer code = jsonReader.read(Integer.class);
        if(code == null) return null;

        // 从class转变为枚举类型
        if (fieldType instanceof Class && Enum.class.isAssignableFrom((Class<?>) fieldType)) {
            Class<?> clazz = (Class<?>) fieldType;
            Enum<?>[] enums = (Enum<?>[]) clazz.getEnumConstants();
            for (Enum<?> e : enums) {
                if (e instanceof BaseEnum && ((BaseEnum) e).getValue().equals(code)) {
                    return e;
                }
            }
        }
        return null;
    }
}
