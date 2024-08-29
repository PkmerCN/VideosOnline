package org.hzz.api.coupon.controller;

import io.gitee.pkmer.security.context.AppContextHolder;
import org.hzz.api.coupon.CouponApi;
import org.hzz.application.command.AddCouponCmd;
import org.hzz.application.service.PromotionsCmdService;
import io.gitee.pkmer.convention.controller.BaseController;
import io.gitee.pkmer.convention.result.Result;
import org.hzz.promotions.types.req.AddCouponReq;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
@RestController
public class CouponController extends BaseController implements CouponApi {

    @Setter(onMethod_ = {@Autowired})
    private PromotionsCmdService cmdService;

    @Override
    public Result<Void> saveCoupon(AddCouponReq addCouponReq) {
        logger.info("saveCoupon: {}", addCouponReq.getName());

        Long userId = AppContextHolder.userContextHolder.getUser().getId();
        Converter.INSTANCE
                .toAddCouponCmd(addCouponReq)
                .setCreater(userId)
                .setUpdater(userId)
                .execute(cmdService);
        return success(null);
    }

    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
        AddCouponCmd toAddCouponCmd(AddCouponReq addCouponReq);
    }
}
