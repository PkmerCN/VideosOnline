package org.hzz.course.types.enums.catalogue;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;
import org.hzz.core.enums.BaseEnumTemplate;

/**
 * 目录类型1：章，2：节，3：测试
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
@Getter
public enum CatalogueType implements BaseEnum {
    CHAPTER(1,"章"),
    SECTION(2,"节"),
    EXAM(3,"测试");

    private final Integer value;
    private final String desc;

    CatalogueType(Integer value,String desc){
        this.desc = desc;
        this.value = value;
    }

    public static CatalogueType fromValue(Byte value){
        return BaseEnumTemplate.fromByteValue(CatalogueType.class,value);
    }
}
