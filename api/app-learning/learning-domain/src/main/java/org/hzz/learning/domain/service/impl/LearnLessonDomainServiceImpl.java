package org.hzz.learning.domain.service.impl;

import org.hzz.course.domain.entity.CourseSimpleInfoDto;
import org.hzz.learning.domain.aggregate.EnrollCourseAggregate;
import org.hzz.learning.domain.service.LearnLessonDomainService;
import org.hzz.learning.domain.valueobject.EnrollerLesson;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Service
public class LearnLessonDomainServiceImpl  implements LearnLessonDomainService {
    @Override
    public void enrollCourse(EnrollCourseAggregate enrollCourse) {
        List<EnrollerLesson> enrollerLessonList  = new ArrayList<>();
        Long userId = enrollCourse.getUserId();
        for(CourseSimpleInfoDto course: enrollCourse.getCourses()){
            EnrollerLesson lesson = new EnrollerLesson();
            lesson.setUserId(userId);
            lesson.setCourseId(course.getId());
            // 计算过期时间
            lesson.setExpireTime(LocalDateTime.now()
                    .plusMonths(course.getValidDuration()));
        }

    }
}
