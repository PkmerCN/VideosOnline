package org.hzz.learning.domain.service;

import org.hzz.learning.domain.aggregate.EnrollCourseAggregate;
import org.hzz.learning.domain.entity.LearningLessonEntity;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
public interface LearnLessonDomainService{

    void enrollCourse(EnrollCourseAggregate enrollCourse);

    /**
     * 查询课程
     * @param userId 用户Id
     * @param courseId 课程Id
     * @return Lesson
     */
    LearningLessonEntity queryLesson(Long userId, Long courseId);
}
