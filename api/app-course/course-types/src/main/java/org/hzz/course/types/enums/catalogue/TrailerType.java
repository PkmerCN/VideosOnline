package org.hzz.course.types.enums.catalogue;

import lombok.Getter;
import org.hzz.core.enums.BaseEnumTemplate;
import org.hzz.core.enums.BaseEnum;

/**
 * 是否支持试看
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
@Getter
public enum TrailerType implements BaseEnum<Integer> {
    NO(0,"不支持试看"),
    YES(1,"支持试看");

    private final Integer value;
    private final String desc;

    TrailerType(Integer value, String desc){
        this.desc = desc;
        this.value = value;
    }

    public static TrailerType fromValue(Byte value){
        return BaseEnumTemplate.fromByteValue(TrailerType.class,value);
    }
}
