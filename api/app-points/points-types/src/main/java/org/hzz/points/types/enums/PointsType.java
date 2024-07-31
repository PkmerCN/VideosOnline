package org.hzz.points.types.enums;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;
import org.hzz.core.enums.BaseEnumTemplate;

/**
 * {@link org.hzz.points.infrastructure.dao.handler.PointsTypeHandler}
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
@Getter
public enum PointsType implements BaseEnum<Integer> {
    COURSE_LEARN(1, "课程学习", 50),
    SIGN_EVERYDAY(2, "每日签到", 1),
    QUESTION_REPLY(3, "课程问答", 20),
    COURSE_NOTES(4, "课程笔记", 20),
    COURSE_EVALUATION(5, "课程评价", 50);

    private final Integer value;
    private final String desc;
    /**
     * 积分上限
     */
    private final Integer maxPoints;

    PointsType(Integer value, String desc, Integer maxPoints) {
        this.desc = desc;
        this.value = value;
        this.maxPoints = maxPoints;
    }

    public static PointsType fromValue(Byte value) {
        return BaseEnumTemplate.fromByteValue(PointsType.class, value);
    }
}
