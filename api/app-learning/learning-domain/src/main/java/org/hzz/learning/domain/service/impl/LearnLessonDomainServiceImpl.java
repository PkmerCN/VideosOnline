package org.hzz.learning.domain.service.impl;

import lombok.Setter;
import org.hzz.core.exception.db.AppDbEntityNotFoundException;
import org.hzz.core.exception.db.AppDbUpdateException;
import org.hzz.core.service.BaseDomainService;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.domain.service.CourseDomainService;
import org.hzz.learning.domain.aggregate.EnrollCourseAggregate;
import org.hzz.learning.domain.aggregate.LearnLessonAggregate;
import org.hzz.learning.domain.entity.LearningLessonEntity;
import org.hzz.learning.domain.repository.LearnLessonRepository;
import org.hzz.learning.domain.service.LearnLessonDomainService;
import org.hzz.learning.domain.valueobject.EnrollerLesson;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Setter(onMethod_ = @Autowired)
    private CourseDomainService courseDomainService;

    /**
     * 用户订阅课程
     * @param enrollCourse 用户订阅的课程
     */
    @Override
    public void enrollCourse(EnrollCourseAggregate enrollCourse) {
        List<EnrollerLesson> enrollerLessonList  = new ArrayList<>();
        Long userId = enrollCourse.getUserId();
        for(CourseEntity course: enrollCourse.getCourses()){
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

    @Override
    public void updateLessonSelectiveById(LearningLessonEntity entity) {
        int i = repository.updateLearnLesson(entity);
        logger.info("更新{}条 Success",i);
        if(i == 0){
            throw new AppDbUpdateException("更新learning lesson失败");
        }
    }

    @Override
    public LearningLessonEntity queryLesson(Long userId, Long courseId) {
        LearningLessonEntity learningLesson = repository.getLearningLesson(userId, courseId);

        if(learningLesson == null){
            throw new AppDbEntityNotFoundException("该用户该课程");
        }

        return learningLesson;
    }

    @Override
    public LearningLessonEntity queryLesson(Long lessonId) {
        return repository.getLearningLesson(lessonId);
    }

    /**
     * 获取聚合根
     * 包含LearningLesson和Course
     * @param lessonId
     * @return
     */
    @Override
    public LearnLessonAggregate getLearnLessonAggregate(Long lessonId) {
        LearningLessonEntity learningLessonEntity = queryLesson(lessonId);
        CourseEntity course = courseDomainService.findCourse(learningLessonEntity.getCourseId());

        return new LearnLessonAggregate()
                .setLearningLesson(learningLessonEntity)
                .setCourseEntity(course);
    }
}
