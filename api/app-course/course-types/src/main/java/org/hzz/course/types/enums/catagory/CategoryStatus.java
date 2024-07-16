package org.hzz.course.types.enums.catagory;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;
import org.hzz.core.enums.BaseEnumTemplate;

/**
 * 分类状态
 * 课程分类状态，1：正常，2：禁用
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Getter
public enum CategoryStatus implements BaseEnum {
    NORMAL(1,"正常"),
    DISABLE(2,"禁用");

    private final Integer value;
    private final String desc;

    CategoryStatus(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static CategoryStatus fromValue(Byte value){
        return BaseEnumTemplate.fromByteValue(CategoryStatus.class,value);
    }
}
