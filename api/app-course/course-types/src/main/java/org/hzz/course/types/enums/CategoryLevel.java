package org.hzz.course.types.enums;

import org.hzz.core.enums.BaseEnum;

/**
 * 一级分类，二级分类，三级分类
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public enum CategoryLevel implements BaseEnum {
    FIRST(1,"一级分类"),
    SECOND(2,"二级分类"),
    THIRD(3,"三级分类");
    private final Integer value;
    private final String desc;

    private CategoryLevel(Integer value,String desc){
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

    public static CategoryLevel fromValue(Integer value){
        if(value == null){
            return null;
        }

        for (CategoryLevel level: CategoryLevel.values()){
            if(level.getValue().equals(value)){
                return level;
            }
        }

        throw new IllegalArgumentException("Unknown enum value: " + value + "in CategoryLevel");
    }
}
