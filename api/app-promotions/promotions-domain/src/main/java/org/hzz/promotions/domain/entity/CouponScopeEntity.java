package org.hzz.promotions.domain.entity;

import io.gitee.pkmer.ddd.shared.Entity;
import org.hzz.promotions.types.enums.coupon.CouponScopeType;
import lombok.Data;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
@Data
public class CouponScopeEntity implements Entity {
    private Long id;

    // 范围限定类型：1-分类，2-课程，等等
    private CouponScopeType type;

    // 优惠券id
    private Long couponId;

    // 优惠券作用范围的业务id，例如分类id、课程id
    private Long bizId;
}
