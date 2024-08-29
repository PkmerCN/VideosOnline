package org.hzz.promotions.domain.service.impl;

import io.gitee.pkmer.convention.service.BaseDomainService;
import org.hzz.promotions.domain.entity.CouponEntity;
import org.hzz.promotions.domain.repository.CouponRepository;
import org.hzz.promotions.domain.service.CouponDomainService;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
@Service
public class CouponDomainServiceImpl
        extends BaseDomainService<CouponRepository>
        implements CouponDomainService {


    @Override
    public void insertCoupon(CouponEntity coupon) {
        repository.insertCoupon(coupon);
    }
}
