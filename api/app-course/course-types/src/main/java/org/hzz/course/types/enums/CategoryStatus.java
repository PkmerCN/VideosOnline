package org.hzz.course.types.enums;

import org.hzz.core.enums.BaseEnum;

/**
 * 分类状态
 * 课程分类状态，1：正常，2：禁用
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public enum CategoryStatus implements BaseEnum {
    NORMAL(1,"正常"),
    DISABLE(2,"禁用");

    private final Integer value;
    private final String desc;

    private CategoryStatus(Integer value,String desc){
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

    public static CategoryStatus fromValue(Byte value){
        if(value == null){
            return null;
        }
        for (CategoryStatus status: CategoryStatus.values()){
            if(status.getValue().equals(value.intValue())){
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + "in CategoryStatus");
    }
}