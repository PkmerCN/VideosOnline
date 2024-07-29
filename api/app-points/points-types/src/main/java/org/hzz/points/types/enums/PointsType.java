package org.hzz.points.types.enums;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;
import org.hzz.core.enums.BaseEnumTemplate;

/**
 * {@link org.hzz.points.infrastructure.dao.handler.PointsTypeHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
@Getter
public enum PointsType implements BaseEnum<Integer> {
    COURSE_LEARN(1,"课程学习"),
    SIGN_EVERYDAY(2,"每日签到"),
    QUESTION_REPLY(3,"课程问答"),
    COURSE_NOTES(4,"课程笔记"),
    COURSE_EVALUATION(5,"课程评价");

    private final Integer value;
    private final String desc;

    PointsType(Integer value,String desc){
        this.desc = desc;
        this.value = value;
    }

    public static PointsType fromValue(Byte value){
        return BaseEnumTemplate.fromByteValue(PointsType.class,value);
    }
}
