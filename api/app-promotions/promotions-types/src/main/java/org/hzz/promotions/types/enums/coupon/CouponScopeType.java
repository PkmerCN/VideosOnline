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
public enum CouponScopeType implements BaseEnum<Integer> {

    // 范围限定类型：1-分类，2-课程，等等
    CATEGORY(1, "分类"),
    COURSE(2, "课程");
    private final Integer value;
    private final String desc;
    CouponScopeType(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static CouponScopeType fromValue(Byte value) {
        return BaseEnumTemplate.fromByteValue(CouponScopeType.class, value);
    }
}
