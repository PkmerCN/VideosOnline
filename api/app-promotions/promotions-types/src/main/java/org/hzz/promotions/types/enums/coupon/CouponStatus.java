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
public enum CouponStatus implements BaseEnum<Integer> {
    // 优惠券配置状态，1：待发放，2：未开始   3：进行中，4：已结束，5：暂停
    UN_PUBLISH(1,"未发布"),
    NOT_START(2,"未开始"),
    ONGOING(3,"进行中"),
    END(4,"已结束"),
    PAUSE(5,"暂停");
    private final String desc;
    private final Integer value;

    CouponStatus(Integer value,String desc){
        this.desc = desc;
        this.value = value;
    }

    public static CouponStatus fromValue(Byte value){
        return BaseEnumTemplate.fromByteValue(CouponStatus.class,value);
    }

}
