package org.hzz.points.types.constants;

/**
* This class contains the database column names for the points_board table.
* Generator by TableFields.ftl
*
* @author 胖卡
* @date 2024-07-31
*/
public class PointsBoardFields {

    /**
     * 榜单id
     */
    public static final String ID = "id";

    /**
     * 学生id
     */
    public static final String USER_ID = "user_id";

    /**
     * 积分值
     */
    public static final String POINTS = "points";

    /**
     * 名次，只记录赛季前100
     */
    public static final String RANK = "rank";

    /**
     * 赛季id
     */
    public static final String SEASON = "season";
}