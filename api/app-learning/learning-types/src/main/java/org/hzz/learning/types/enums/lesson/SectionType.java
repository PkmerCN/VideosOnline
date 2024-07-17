package org.hzz.learning.types.enums.lesson;

import org.hzz.core.enums.BaseEnum;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
public enum SectionType implements BaseEnum {
    VIDEO(1, "视频"),
    EXAM(2, "考试");
    private final Integer value;
    private final String desc;

    private SectionType(Integer value,String desc){
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
}
