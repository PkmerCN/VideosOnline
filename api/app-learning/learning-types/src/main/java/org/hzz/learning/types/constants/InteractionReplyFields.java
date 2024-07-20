package org.hzz.learning.types.constants;

/**
* This class contains the database column names for the interaction_reply table.
* Generator by TableFields.ftl
*
* @author 胖卡
* @date 2024-07-20
*/
public class InteractionReplyFields {

    /**
     * 互动问题的回答id
     */
    public static final String ID = "id";

    /**
     * 互动问题问题id
     */
    public static final String QUESTION_ID = "question_id";

    /**
     * 回复的上级回答id
     */
    public static final String ANSWER_ID = "answer_id";

    /**
     * 回答者id
     */
    public static final String USER_ID = "user_id";

    /**
     * 回答内容
     */
    public static final String CONTENT = "content";

    /**
     * 回复的目标用户id
     */
    public static final String TARGET_USER_ID = "target_user_id";

    /**
     * 回复的目标回复id
     */
    public static final String TARGET_REPLY_ID = "target_reply_id";

    /**
     * 评论数量
     */
    public static final String REPLY_TIMES = "reply_times";

    /**
     * 点赞数量
     */
    public static final String LIKED_TIMES = "liked_times";

    /**
     * 是否被隐藏，默认false
     */
    public static final String HIDDEN = "hidden";

    /**
     * 是否匿名，默认false
     */
    public static final String ANONYMITY = "anonymity";

    /**
     * 创建时间
     */
    public static final String CREATE_TIME = "create_time";

    /**
     * 更新时间
     */
    public static final String UPDATE_TIME = "update_time";
}