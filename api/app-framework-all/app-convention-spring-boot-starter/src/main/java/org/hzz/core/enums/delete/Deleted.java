package org.hzz.core.enums.delete;

import lombok.Getter;
import org.hzz.core.enums.BaseEnum;
import org.hzz.core.enums.BaseEnumTemplate;

/**
 * 是否逻辑删除
 * {@link }
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Getter
public enum Deleted implements BaseEnum {
    NO(0,"未删除"),
    YES(1,"已删除");

    private final Integer value;
    private final String desc;

    Deleted(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static Deleted fromValue(Byte value){
        return BaseEnumTemplate.fromByteValue(Deleted.class,value);
    }
}
