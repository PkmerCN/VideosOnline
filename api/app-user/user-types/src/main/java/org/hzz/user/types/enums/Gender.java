package org.hzz.user.types.enums;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;
import org.hzz.core.enums.BaseEnumTemplate;

/**
 * 性别枚举
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Getter
public enum Gender implements BaseEnum<Integer> {
    MAN(0,"男性"),
    WOMAN(1,"女性"),
    UNKNOWN(2,"未知");

    private final Integer value;
    private final String desc;

    private Gender(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }


    public static Gender fromValue(Byte value) {
        return BaseEnumTemplate.fromByteValue(Gender.class,value);
    }
}
