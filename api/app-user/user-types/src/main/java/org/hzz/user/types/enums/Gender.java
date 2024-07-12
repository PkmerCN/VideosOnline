package org.hzz.user.types.enums;

import org.hzz.core.enums.BaseEnum;

/**
 * 性别枚举
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
public enum Gender implements BaseEnum {
    MAN(0,"男性"),
    WOMAN(1,"女性"),
    UNKNOWN(2,"未知");

    private final Integer value;
    private final String desc;

    private Gender(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public static Gender fromValue(Byte value) {
        if (value == null) {
            return null;
        }
        for (Gender status : Gender.values()) {
            assert status.getValue() != null;
            if (status.getValue().equals(value.intValue())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + "in PlanStatus");
    }
}
