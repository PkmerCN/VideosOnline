package org.hzz.points.types.constants;

/**
* This class contains the database column names for the points_record table.
* Generator by TableFields.ftl
*
* @author 胖卡
* @date 2024-07-29
*/
public class PointsRecordFields {

    /**
     * 积分记录表id
     */
    public static final String ID = "id";

    /**
     * 用户id
     */
    public static final String USER_ID = "user_id";

    /**
     * 积分方式：1-课程学习，2-每日签到，3-课程问答， 4-课程笔记，5-课程评价
     */
    public static final String TYPE = "type";

    /**
     * 积分值
     */
    public static final String POINTS = "points";

    /**
     * 创建时间
     */
    public static final String CREATE_TIME = "create_time";
}