package org.hzz.learning.domain.service;

import org.hzz.learning.domain.aggregate.EnrollCourseAggregate;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
public interface LearnLessonDomainService {

    void enrollCourse(EnrollCourseAggregate enrollCourse);
}
