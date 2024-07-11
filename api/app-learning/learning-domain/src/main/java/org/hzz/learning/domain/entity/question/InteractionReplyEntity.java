package org.hzz.learning.domain.entity.question;

import org.hzz.ddd.core.domain.shared.Entity;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
public class InteractionReplyEntity implements Entity {
    // 互动问题的回答id
    private Long id;

    // 互动问题问题id
    private Long questionId;

    // 回复的上级回答id
    private Long answerId;

    // 回答者id
    private Long userId;

    // 回答内容
    private String content;

    // 回复的目标用户id
    private Long targetUserId;

    // 回复的目标回复id
    private Long targetReplyId;

    // 评论数量
    private Integer replyTimes;

    // 点赞数量
    private Integer likedTimes;

    // 是否被隐藏，默认false
    private Boolean hidden;

    // 是否匿名，默认false
    private Boolean anonymity;
}
