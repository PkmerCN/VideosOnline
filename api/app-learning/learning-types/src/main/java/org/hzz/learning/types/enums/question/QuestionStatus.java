package org.hzz.learning.types.enums.question;

import org.hzz.core.enums.BaseEnum;

/**
 * 管理端问题状态
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
public enum QuestionStatus implements BaseEnum {
    UN_CHECK(0, "未查看"),
    CHECKED(1, "已查看");
    private final Integer value;
    private final String desc;

    private QuestionStatus(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }


    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getDesc() {
        return this.desc;
    }
}
