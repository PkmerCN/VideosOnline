package org.hzz.learning.domain.entity;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.Entity;
import org.hzz.learning.types.enums.lesson.LessonStatus;
import org.hzz.learning.types.enums.lesson.PlanStatus;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
public class LearningLessonEntity implements Entity {
    private Long id;
    private Long userId;
    private Long courseId;
    private LessonStatus lessonStatus;
    private PlanStatus planStatus;
    private Byte weekFreq;
    /**
     * 已经学习的小节数量
     */
    private Integer learnedSections;
    /**
     * 总小节数量
     */
    private Integer sections;
    private Long latestSectionId;
    // 最近一次学习的时间
    private LocalDateTime latestLearnTime;
    private LocalDateTime createTime;
    private LocalDateTime expireTime;
}
