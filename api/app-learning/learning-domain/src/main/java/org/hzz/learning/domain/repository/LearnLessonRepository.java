package org.hzz.learning.domain.repository;

import org.hzz.learning.domain.entity.LearningLessonEntity;
import org.hzz.learning.domain.valueobject.EnrollerLesson;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
public interface LearnLessonRepository {

        void saveBath(List<EnrollerLesson> lessonList);

        LearningLessonEntity getLearningLesson(Long userId, Long courseId);
        LearningLessonEntity getLearningLesson(Long lessonId);

}
