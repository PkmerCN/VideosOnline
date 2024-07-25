package org.hzz.remark.types;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;
import org.hzz.core.enums.BaseEnumTemplate;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/24
 */
@Getter
public enum BizType implements BaseEnum<String> {
    QA("QA","问答业务")
    ;

    private final String value;
    private final String desc;

    BizType(String type,String desc){
        this.value = type;
        this.desc = desc;
    }

    public static BizType fromValue(String value){
        return BaseEnumTemplate.fromStringValue(BizType.class,value);
    }
}
