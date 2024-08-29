package org.hzz.coupon.infrastructure.dao.handler;

import io.gitee.pkmer.convention.handler.ByteTypeHandler;
import org.hzz.promotions.types.enums.coupon.CouponScopeType;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
public class CouponScopeTypeHandler extends ByteTypeHandler<CouponScopeType> {
    @Override
    protected CouponScopeType fromValue(Byte value) {
        return CouponScopeType.fromValue(value);
    }
}
