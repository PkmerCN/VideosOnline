package org.hzz.promotions.domain.repository;

import org.hzz.promotions.domain.entity.CouponEntity;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
public interface CouponRepository {

    /**
     * 插入Coupon对象
     */
    void insertCoupon(CouponEntity coupon);

}

