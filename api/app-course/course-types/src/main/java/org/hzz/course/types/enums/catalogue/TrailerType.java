package org.hzz.course.types.enums.catalogue;

import org.hzz.core.enums.BaseEnumTemplate;
import org.hzz.core.enums.BaseEnum;

/**
 * 是否支持试看
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
public enum TrailerType implements BaseEnum {
    NO(0,"不支持试看"),
    YES(1,"支持试看");

    private final Integer value;
    private final String desc;


    TrailerType(Integer value, String desc){
        // 枚举类构造方法不允许有super
        //super(TrailerType.class);
        this.desc = desc;
        this.value = value;
    }
    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public static TrailerType fromValue(Byte value){
        return BaseEnumTemplate.fromValue(TrailerType.class,value);
    }
}
