package org.hzz.course.types.enums.teacher;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;
import org.hzz.core.enums.BaseEnumTemplate;

/**
 * 用户端是否展示
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Getter
public enum IsShow implements BaseEnum<Integer> {
    NO(0,"不展示"),
    YES(1,"展示");

    private final Integer value;
    private final String desc;

    IsShow(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static IsShow fromValue(Byte value){
        return BaseEnumTemplate.fromByteValue(IsShow.class,value);
    }
}
