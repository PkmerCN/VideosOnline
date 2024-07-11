package org.hzz.learning.domain.entity.question;

import org.hzz.ddd.core.domain.shared.Entity;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
public class InteractionQuestionEntity implements Entity {
    // 主键，互动问题的id
    private Long id;

    // 互动问题的标题
    private String title;

    // 问题描述信息
    private String description;

    // 所属课程id
    private Long courseId;

    // 所属课程章id
    private Long chapterId;

    // 所属课程节id
    private Long sectionId;

    // 提问学员id
    private Long userId;

    // 最新的一个回答的id
    private Long latestAnswerId;

    // 问题下的回答数量
    private Integer answerTimes;

    // 是否匿名，默认false
    private Boolean anonymity;

    // 是否被隐藏，默认false
    private Boolean hidden;

    // 管理端问题状态：0-未查看，1-已查看
    private Byte status;
}
