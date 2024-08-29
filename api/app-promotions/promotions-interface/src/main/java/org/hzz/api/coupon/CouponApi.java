package org.hzz.api.coupon;

import io.gitee.pkmer.convention.result.Result;
import org.hzz.promotions.types.req.AddCouponReq;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
@RequestMapping("/coupons")
public interface CouponApi {

    @ApiResponse
    @Operation(description = "新增优惠券")
    @PostMapping
    Result<Void> saveCoupon(@Validated @RequestBody AddCouponReq addCouponReq);
}
