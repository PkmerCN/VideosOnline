package org.hzz.learning.infrastructure.converter;

import org.hzz.learning.domain.valueobject.EnrollerLesson;
import org.hzz.learning.infrastructure.dao.entity.lesson.LearningLesson;
import org.mapstruct.Mapper;


import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Mapper(componentModel = "spring")
public interface EnrollerLessonConverter{

    LearningLesson mapToLearningLesson(EnrollerLesson enrollerLesson);

    List<LearningLesson> mapToLearningLessonList(List<EnrollerLesson> enrollerLessons);
}
