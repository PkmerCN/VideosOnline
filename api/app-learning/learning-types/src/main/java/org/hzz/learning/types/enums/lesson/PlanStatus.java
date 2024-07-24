package org.hzz.learning.types.enums.lesson;

import org.hzz.core.enums.BaseEnum;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public enum PlanStatus implements BaseEnum<Integer> {
    NOT_PLAN(0,"没有计划"),
    PLAN_RUNNING(1,"计划进行中");

    private final Integer value;
    private final String desc;

    private PlanStatus(Integer value,String desc){
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

    public static PlanStatus fromValue(Byte value) {
        if (value == null) {
            return null;
        }
        for (PlanStatus status : PlanStatus.values()) {
            if (status.getValue().equals(value.intValue())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + "in PlanStatus");
    }
}
