package org.hzz.learning.domain.handler;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.course.domain.aggregate.CourseIdAggregate;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.domain.service.course.CourseDomainService;
import org.hzz.learning.domain.aggregate.EnrollCourseAggregate;
import org.hzz.learning.domain.event.LearningLessonAddEvent;
import org.hzz.learning.domain.service.lesson.LearnLessonDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 处理添加课程事件
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Component
@Slf4j
public class LearningLessonAddEventHandler {

    @Setter(onMethod_ = @Autowired)
    private CourseDomainService courseDomainService;
    @Setter(onMethod_ = @Autowired)
    private LearnLessonDomainService learnLessonDomainService;


    @EventListener
    public void handleLearningLessonAddEvent(LearningLessonAddEvent event) {
        log.info("准备处理: {}", event);
        CourseIdAggregate dto = CourseIdAggregate.builder()
                .ids(event.getCouseIds())
                .build();

        List<CourseEntity> courses = courseDomainService.findCourses(dto);

        learnLessonDomainService.enrollCourse(EnrollCourseAggregate.builder()
                .courses(courses)
                .userId(event.getUserId())
                .build());
    }
}
