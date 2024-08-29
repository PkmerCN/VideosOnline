package org.hzz.coupon.infrastructure.dao.mapper.coupon;

import jakarta.annotation.Generated;
import org.hzz.promotions.types.enums.coupon.CouponStatus;
import org.hzz.promotions.types.enums.coupon.DiscountType;
import org.hzz.promotions.types.enums.coupon.ObtainWay;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

import java.sql.JDBCType;
import java.time.LocalDateTime;

public final class CouponDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Coupon coupon = new Coupon();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = coupon.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> name = coupon.name;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> type = coupon.type;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<DiscountType> discountType = coupon.discountType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Boolean> specific = coupon.specific;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> discountValue = coupon.discountValue;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> thresholdAmount = coupon.thresholdAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> maxDiscountAmount = coupon.maxDiscountAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<ObtainWay> obtainWay = coupon.obtainWay;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> issueBeginTime = coupon.issueBeginTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> issueEndTime = coupon.issueEndTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> termDays = coupon.termDays;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> termBeginTime = coupon.termBeginTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> termEndTime = coupon.termEndTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<CouponStatus> status = coupon.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> totalNum = coupon.totalNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> issueNum = coupon.issueNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> usedNum = coupon.usedNum;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> userLimit = coupon.userLimit;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> createTime = coupon.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<LocalDateTime> updateTime = coupon.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> creater = coupon.creater;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> updater = coupon.updater;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> extParam = coupon.extParam;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Coupon extends AliasableSqlTable<Coupon> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<Byte> type = column("`type`", JDBCType.TINYINT);

        public final SqlColumn<DiscountType> discountType = column("discount_type", JDBCType.TINYINT);

        public final SqlColumn<Boolean> specific = column("`specific`", JDBCType.BIT);

        public final SqlColumn<Integer> discountValue = column("discount_value", JDBCType.INTEGER);

        public final SqlColumn<Integer> thresholdAmount = column("threshold_amount", JDBCType.INTEGER);

        public final SqlColumn<Integer> maxDiscountAmount = column("max_discount_amount", JDBCType.INTEGER);

        public final SqlColumn<ObtainWay> obtainWay = column("obtain_way", JDBCType.TINYINT);

        public final SqlColumn<LocalDateTime> issueBeginTime = column("issue_begin_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> issueEndTime = column("issue_end_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> termDays = column("term_days", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> termBeginTime = column("term_begin_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> termEndTime = column("term_end_time", JDBCType.TIMESTAMP);

        public final SqlColumn<CouponStatus> status = column("`status`", JDBCType.TINYINT);

        public final SqlColumn<Integer> totalNum = column("total_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> issueNum = column("issue_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> usedNum = column("used_num", JDBCType.INTEGER);

        public final SqlColumn<Integer> userLimit = column("user_limit", JDBCType.INTEGER);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> creater = column("creater", JDBCType.BIGINT);

        public final SqlColumn<Long> updater = column("updater", JDBCType.BIGINT);

        public final SqlColumn<String> extParam = column("ext_param", JDBCType.LONGVARCHAR);

        public Coupon() {
            super("coupon", Coupon::new);
        }
    }
}