package org.hzz.promotions.types.enums.coupon;

import io.gitee.pkmer.convention.enums.BaseEnum;
import io.gitee.pkmer.convention.enums.BaseEnumTemplate;
import lombok.Getter;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
@Getter
public enum ObtainWay implements BaseEnum<Integer> {
    // 获取方式：1：手动领取，2：兑换码

    GET_BY_HAND(1,"手动领取"),
    CODE(2,"兑换码");

    private final Integer value;
    private final String desc;

    ObtainWay(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static ObtainWay fromValue(Byte value){
       return BaseEnumTemplate.fromByteValue(ObtainWay.class,value);
    }

}
