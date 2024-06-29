package org.hzz.learning.domain.aggregate;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.ddd.core.domain.shared.AggregateRoot;
import org.hzz.learning.domain.entity.LearningLessonEntity;

/**
 * 学习聚合根
 * 包含lesson和course
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
@Accessors(chain = true)
public class LearnLessonAggregate implements AggregateRoot {
    LearningLessonEntity learningLesson;
    CourseEntity courseEntity;
}
