package org.hzz.learning.domain.service.lesson.impl;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.page.PageResponse;
import org.hzz.core.service.BaseDomainService;
import org.hzz.course.domain.aggregate.CourseIdAggregate;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.domain.service.course.CourseDomainService;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.learning.domain.repository.LearnLessonPageRepository;
import org.hzz.learning.domain.service.lesson.LearningLessonPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分页相关服务
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Service
public class LearningLessonPageServiceImpl extends BaseDomainService<LearnLessonPageRepository> implements LearningLessonPageService {

    @Setter(onMethod_ = @Autowired)
    private CourseDomainService courseDomainService;

    @Override
    public PageResponse<LearningLessonAggregate> pageQueryLesson(LearningLessonAggregate LearnLessonPageRepository) {
        PageResponse<LearningLessonAggregate> result = repository.selectPage(LearnLessonPageRepository);
        initCourse(result.getList());
        return result;
    }

    private void initCourse(List<LearningLessonAggregate> lessons) {
        List<Long> courseIds = lessons.stream().map(LearningLessonAggregate::getCourseId).collect(Collectors.toList());
        Map<Long, CourseEntity> courseMap = queryCourseInfo(courseIds);

        for (LearningLessonAggregate lesson : lessons) {
            lesson.setCourse(courseMap.get(lesson.getCourseId()));
        }
    }

    private Map<Long, CourseEntity> queryCourseInfo(List<Long> courseIds) {
        List<CourseEntity> courses = courseDomainService.findCourses(CourseIdAggregate.builder().ids(courseIds).build());

        if (CollUtil.isEmpty(courses)) {
            throw new RuntimeException("课程信息不存在");
        }

        return courses.stream().collect(Collectors.toMap(CourseEntity::getId, c -> c));
    }
}
