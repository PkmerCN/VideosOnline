package org.hzz.course.types.enums.catalogue;

import org.hzz.core.enums.BaseEnum;

/**
 * 目录类型1：章，2：节，3：测试
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
public enum CatalogueType implements BaseEnum {
    CHAPTER(1,"章"),
    SECTION(2,"节"),
    EXAM(3,"测试");

    private final Integer value;
    private final String desc;

    private CatalogueType(Integer value,String desc){
        this.desc = desc;
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getDesc() {
        return desc;
    }

    public static CatalogueType fromValue(Byte value){
        if(value == null){
            return null;
        }

        for (CatalogueType type: CatalogueType.values()){
            if(type.getValue().equals(value.intValue())){
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + "in CatalogueType");
    }
}
