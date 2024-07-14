package org.hzz.core.enums.delete;

import org.hzz.core.enums.BaseEnum;

/**
 * 是否逻辑删除
 * {@link }
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public enum Deleted implements BaseEnum {
    NO(0,"未删除"),
    YES(1,"已删除");
    private final Integer value;
    private final String desc;
    private Deleted(Integer value,String desc){
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

    public static Deleted fromValue(Byte value){
        if(value == null){
            return null;
        }

        for(Deleted e: Deleted.values()){
            if(e.getValue().equals(value.intValue())){
                return e;
            }
        }
        throw new IllegalArgumentException("Unknown enum value: " + value + "in Deleted");
    }
}
