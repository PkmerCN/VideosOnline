package io.gitee.pkmer.coupon.types.constants;

/**
* This class contains the database column names for the coupon table.
* Generator by TableFields.ftl
*
* @author 胖卡
* @date 2024-08-29
*/
public class CouponFields {

    /**
     * 优惠券id
     */
    public static final String ID = "id";

    /**
     * 优惠券名称，可以和活动名称保持一致
     */
    public static final String NAME = "name";

    /**
     * 优惠券类型，1：普通券。目前就一种，保留字段
     */
    public static final String TYPE = "type";

    /**
     * 折扣类型，1：满减，2：每满减，3：折扣，4：无门槛
     */
    public static final String DISCOUNT_TYPE = "discount_type";

    /**
     * 是否限定作用范围，false：不限定，true：限定。默认false
     */
    public static final String SPECIFIC = "specific";

    /**
     * 折扣值，如果是满减则存满减金额，如果是折扣，则存折扣率，8折就是存80
     */
    public static final String DISCOUNT_VALUE = "discount_value";

    /**
     * 使用门槛，0：表示无门槛，其他值：最低消费金额
     */
    public static final String THRESHOLD_AMOUNT = "threshold_amount";

    /**
     * 最高优惠金额，满减最大，0：表示没有限制，不为0，则表示该券有金额的限制
     */
    public static final String MAX_DISCOUNT_AMOUNT = "max_discount_amount";

    /**
     * 获取方式：1：手动领取，2：兑换码
     */
    public static final String OBTAIN_WAY = "obtain_way";

    /**
     * 开始发放时间
     */
    public static final String ISSUE_BEGIN_TIME = "issue_begin_time";

    /**
     * 结束发放时间
     */
    public static final String ISSUE_END_TIME = "issue_end_time";

    /**
     * 优惠券有效期天数，0：表示有效期是指定有效期的
     */
    public static final String TERM_DAYS = "term_days";

    /**
     * 优惠券有效期开始时间
     */
    public static final String TERM_BEGIN_TIME = "term_begin_time";

    /**
     * 优惠券有效期结束时间
     */
    public static final String TERM_END_TIME = "term_end_time";

    /**
     * 优惠券配置状态，1：待发放，2：未开始   3：进行中，4：已结束，5：暂停
     */
    public static final String STATUS = "status";

    /**
     * 总数量，不超过5000
     */
    public static final String TOTAL_NUM = "total_num";

    /**
     * 已发行数量，用于判断是否超发
     */
    public static final String ISSUE_NUM = "issue_num";

    /**
     * 已使用数量
     */
    public static final String USED_NUM = "used_num";

    /**
     * 每个人限领的数量，默认1
     */
    public static final String USER_LIMIT = "user_limit";

    /**
     * 创建时间
     */
    public static final String CREATE_TIME = "create_time";

    /**
     * 更新时间
     */
    public static final String UPDATE_TIME = "update_time";

    /**
     * 创建人
     */
    public static final String CREATER = "creater";

    /**
     * 更新人
     */
    public static final String UPDATER = "updater";

    /**
     * 拓展参数字段，保留字段
     */
    public static final String EXT_PARAM = "ext_param";
}