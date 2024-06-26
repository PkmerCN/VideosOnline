package org.hzz.learning.domain.service.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.course.domain.entity.CourseSimpleInfoDto;
import org.hzz.learning.domain.aggregate.EnrollCourseAggregate;
import org.hzz.learning.domain.repository.LearnLessonRepository;
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
public class LearnLessonDomainServiceImpl extends BaseDomainService<LearnLessonRepository> implements LearnLessonDomainService {

    /**
     * 用户订阅课程
     * @param enrollCourse 用户订阅的课程
     */
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

            enrollerLessonList.add(lesson);
        }

        repository.saveBath(enrollerLessonList);
        logger.info("用户订阅{}个课程成功",enrollerLessonList.size());
    }
}
