package org.hzz.learning.types.enums.lesson;

import org.hzz.core.enums.BaseEnum;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public enum LessonStatus implements BaseEnum {
    NOT_BEGIN(0,"未学习"),
    LEARNING(1,"学习中"),
    FINISHED(2,"已学完"),
    EXPIRED(3,"已失效");

    private final Integer value;
    private final String desc;

    private LessonStatus(Integer value,String desc){
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

    public static LessonStatus fromValue(Byte value) {
        if (value == null) {
            return null;
        }
        for (LessonStatus status : LessonStatus.values()) {
            if (status.getValue().equals(value.intValue())) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + "in LessonStatus");
    }
}
