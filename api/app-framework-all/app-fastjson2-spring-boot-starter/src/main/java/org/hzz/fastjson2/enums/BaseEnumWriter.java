package org.hzz.fastjson2.enums;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;
import org.hzz.core.enums.BaseEnum;

import java.lang.reflect.Type;

/**
 * {@link org.hzz.core.enums.BaseEnum}序列化
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
public class BaseEnumWriter implements ObjectWriter {
    @Override
    public void write(JSONWriter jsonWriter, Object object, Object fieldName, Type fieldType, long features) {
        if(object == null) jsonWriter.writeNull();
        if(object instanceof BaseEnum){
            jsonWriter.writeInt32(((BaseEnum)object).getValue());
        }else{
            throw new RuntimeException("not support type"+object.getClass().getName());
        }
    }
}
