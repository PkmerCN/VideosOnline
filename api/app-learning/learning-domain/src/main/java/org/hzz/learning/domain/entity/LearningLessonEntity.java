package org.hzz.learning.domain.entity;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.Entity;
import org.hzz.learning.domain.enums.LessonStatus;
import org.hzz.learning.domain.enums.PlanStatus;

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
    private Integer learnedSections;
    private Integer sections;
    private Long latestSectionId;
    private LocalDateTime createTime;
    private LocalDateTime expireTime;
}
