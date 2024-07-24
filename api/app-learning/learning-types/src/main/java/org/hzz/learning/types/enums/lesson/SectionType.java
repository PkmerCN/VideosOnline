package org.hzz.learning.types.enums.lesson;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Getter
public enum SectionType implements BaseEnum<Integer> {
    VIDEO(1, "视频"),
    EXAM(2, "考试");
    private final Integer value;
    private final String desc;

     SectionType(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

}
