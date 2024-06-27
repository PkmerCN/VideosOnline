package org.hzz.learning.application.service;

import org.hzz.core.page.PageRequest;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public interface LearningLessonService {

    void pageQueryLesson(PageRequest pageRequest);
}
