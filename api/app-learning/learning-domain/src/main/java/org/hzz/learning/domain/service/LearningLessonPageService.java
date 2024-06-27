package org.hzz.learning.domain.service;

import org.hzz.learning.domain.aggregate.LearningLessonAggregate;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public interface LearningLessonPageService {

    void pageQueryLesson(LearningLessonAggregate learningLessonAggregate);
}
