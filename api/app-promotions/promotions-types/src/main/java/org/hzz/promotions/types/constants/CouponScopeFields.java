package org.hzz.promotions.types.constants;

/**
* This class contains the database column names for the coupon_scope table.
* Generator by TableFields.ftl
*
* @author 胖卡
* @date 2024-08-29
*/
public class CouponScopeFields {

    /**
     * 
     */
    public static final String ID = "id";

    /**
     * 范围限定类型：1-分类，2-课程，等等
     */
    public static final String TYPE = "type";

    /**
     * 优惠券id
     */
    public static final String COUPON_ID = "coupon_id";

    /**
     * 优惠券作用范围的业务id，例如分类id、课程id
     */
    public static final String BIZ_ID = "biz_id";
}