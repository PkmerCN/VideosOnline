package org.hzz.learning.domain.enums;

import org.hzz.core.enums.BaseEnum;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public enum PlanStatus implements BaseEnum {
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
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
