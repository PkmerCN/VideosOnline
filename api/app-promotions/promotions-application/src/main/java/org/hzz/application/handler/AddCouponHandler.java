package org.hzz.application.handler;

import org.hzz.application.command.AddCouponCmd;
import io.gitee.pkmer.designpattern.strategy.AbstractExecuteStrategy;
import org.hzz.promotions.domain.entity.CouponEntity;
import org.hzz.promotions.domain.service.CouponDomainService;
import lombok.Setter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
@Component
public class AddCouponHandler implements AbstractExecuteStrategy<AddCouponCmd,Void> {

    @Setter(onMethod_ = @Autowired)
    private CouponDomainService domainService;
    @Override
    public String mark() {
        return AddCouponCmd.MARK;
    }

    // todo 处理coupon_scope
    @Transactional
    @Override
    public void execute(AddCouponCmd cmd) {
        CouponEntity coupon = Converter.INSTANCE.toCouponEntity(cmd);
        domainService.insertCoupon(coupon);
    }

    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
        CouponEntity toCouponEntity(AddCouponCmd cmd);
    }
}
