package org.hzz.learning.domain.aggregate;

import lombok.Builder;
import lombok.Data;
import org.hzz.core.page.query.PageQuery;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.ddd.core.domain.shared.AggregateRoot;
import org.hzz.learning.domain.enums.LessonStatus;
import org.hzz.learning.domain.enums.PlanStatus;

import java.time.LocalDateTime;


/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Data
@Builder
public class LearningLessonAggregate implements AggregateRoot {

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


    private PageQuery pageQuery;
    private CourseEntity course;
}
