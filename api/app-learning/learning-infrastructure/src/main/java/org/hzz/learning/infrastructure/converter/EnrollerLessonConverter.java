package org.hzz.learning.infrastructure.converter;

import org.hzz.core.converter.BaseConverter;
import org.hzz.learning.domain.valueobject.EnrollerLesson;
import org.hzz.learning.infrastructure.dao.entity.LearningLesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Mapper(componentModel = "spring")
public interface EnrollerLessonConverter extends BaseConverter {
    @Mappings({
            @Mapping(source = "expireTime",target = "expireTime",qualifiedByName = "mapLocalDateTimeToDate")
    })
    LearningLesson mapToLearningLesson(EnrollerLesson enrollerLesson);

    List<LearningLesson> mapToLearningLessonList(List<EnrollerLesson> enrollerLessons);
}
