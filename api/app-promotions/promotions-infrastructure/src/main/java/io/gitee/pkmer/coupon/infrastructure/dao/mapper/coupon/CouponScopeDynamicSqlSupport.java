package io.gitee.pkmer.coupon.infrastructure.dao.mapper.coupon;

import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;

public final class CouponScopeDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final CouponScope couponScope = new CouponScope();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = couponScope.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> type = couponScope.type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> couponId = couponScope.couponId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> bizId = couponScope.bizId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class CouponScope extends AliasableSqlTable<CouponScope> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Byte> type = column("type", JDBCType.TINYINT);

        public final SqlColumn<Long> couponId = column("coupon_id", JDBCType.BIGINT);

        public final SqlColumn<Long> bizId = column("biz_id", JDBCType.BIGINT);

        public CouponScope() {
            super("coupon_scope", CouponScope::new);
        }
    }
}