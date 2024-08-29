package org.hzz.promotions.types.enums.coupon;

import io.gitee.pkmer.convention.enums.BaseEnum;
import io.gitee.pkmer.convention.enums.BaseEnumTemplate;
import lombok.Getter;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 * 折扣类型
 */
@Getter
public enum DiscountType implements BaseEnum<Integer> {

    /**
     * 折扣类型，1：满减，2：每满减，3：折扣，4：无门槛
     */
    FULL_DISCOUNT(1,"满减"),
    PER_FULL_DISCOUNT(2,"每满减"),
    DISCOUNT(3,"折扣"),
    NO_THRESHOLD(4,"无门槛");

    private final Integer value;
    private final String desc;

     DiscountType(Integer value,String desc){
        this.value = value;
        this.desc = desc;
    }

    public static DiscountType fromValue(Byte value) {
        return BaseEnumTemplate.fromByteValue(DiscountType.class, value);
    }


}
