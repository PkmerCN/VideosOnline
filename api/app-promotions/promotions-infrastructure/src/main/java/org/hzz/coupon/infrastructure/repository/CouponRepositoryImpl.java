package org.hzz.coupon.infrastructure.repository;

import io.gitee.pkmer.convention.converter.RecordAndEntityConverter;
import lombok.Setter;
import org.hzz.coupon.infrastructure.dao.mapper.coupon.CouponDynamicMapper;
import org.hzz.coupon.infrastructure.dao.mapper.coupon.CouponMapper;
import org.hzz.coupon.infrastructure.dao.model.coupon.Coupon;
import org.hzz.coupon.infrastructure.dao.model.coupon.CouponExample;
import org.hzz.promotions.domain.entity.CouponEntity;
import org.hzz.promotions.domain.repository.CouponRepository;
import org.hzz.promotions.types.constants.CouponFields;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.hzz.coupon.infrastructure.dao.mapper.coupon.CouponDynamicSqlSupport.coupon;
import static org.mybatis.dynamic.sql.SqlBuilder.insert;

/**
 * @author <a href="mailto:1193094618@qq.com">pkmer</a>
 * <br>
 * <a href = "https://gitee.com/pkmer/sonatype-central-publisher">Code Repository</a>
 * At 2024/8/29
 */
@Repository
public class CouponRepositoryImpl implements CouponRepository {

    @Setter(onMethod_ = {@Autowired})
    private CouponMapper couponMapper;

    @Setter(onMethod_ = {@Autowired})
    private CouponDynamicMapper couponDynamicMapper;

    /**
     * {@inheritDoc}
     *
     * @param _coupon
     */
    @Override
    public void insertCoupon(CouponEntity _coupon) {
        Coupon record = Converter.INSTANCE.toRecord(_coupon);

        InsertStatementProvider<Coupon> insertSql = insert(record).into(coupon)
                .map(coupon.name).toProperty("name")
                .map(coupon.discountType).toProperty("discountType")
                .map(coupon.specific).toProperty("specific")
                .map(coupon.discountValue).toProperty("discountValue")
                .map(coupon.thresholdAmount).toProperty("thresholdAmount")
                .map(coupon.maxDiscountAmount).toProperty("maxDiscountAmount")
                .map(coupon.obtainWay).toProperty("obtainWay")
                .map(coupon.totalNum).toProperty("totalNum")
                .map(coupon.userLimit).toProperty("userLimit")
                .map(coupon.creater).toProperty("creater")
                .map(coupon.updater).toProperty("updater")

                .build()
                .render(RenderingStrategies.MYBATIS3);

        System.out.println(insertSql.getInsertStatement());

        // todo
        couponDynamicMapper.insert(insertSql);
        couponMapper.insertSelective(record);
        couponDynamicMapper.insertSelective(record);
    }

    @Mapper
    interface Converter extends RecordAndEntityConverter<Coupon, CouponEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
