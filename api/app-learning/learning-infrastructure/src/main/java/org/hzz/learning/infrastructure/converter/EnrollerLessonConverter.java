package org.hzz.learning.infrastructure.converter;

import org.hzz.common.date.DateUtil;
import org.hzz.learning.domain.valueobject.EnrollerLesson;
import org.hzz.learning.infrastructure.dao.entity.LearningLesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Mapper(componentModel = "spring")
public interface EnrollerLessonConverter {
    @Named("mapDateToLocalDateTime")
    default LocalDateTime mapDateToLocalDateTime(Date date) {
        return DateUtil.changeDateToLocalDateTime(date);
    }

    @Named("mapLocalDateTimeToDate")
    default Date mapLocalDateTimeToDate(LocalDateTime dateTime) {
        return DateUtil.changeLocalDateTimeToDate(dateTime);
    }

    @Mappings({
            @Mapping(source = "expireTime",target = "expireTime",qualifiedByName = "mapLocalDateTimeToDate")
    })
    LearningLesson mapToLearningLesson(EnrollerLesson enrollerLesson);

    List<LearningLesson> mapToLearningLessonList(List<EnrollerLesson> enrollerLessons);
}
