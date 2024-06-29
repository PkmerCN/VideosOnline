package org.hzz.learning.infrastructure.converter;

import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.learning.domain.enums.LessonStatus;
import org.hzz.learning.domain.enums.PlanStatus;
import org.hzz.learning.infrastructure.dao.entity.lesson.LearningLesson;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Mapper(componentModel = "spring")
public interface LearnLessonAggregateConverter{

    @Named("mapToPlanStatus")
    default PlanStatus mapToPlanStatus(Byte value) {
        return PlanStatus.fromValue(value);
    }

    @Named("mapToLessonStatus")
    default LessonStatus mapToLessonStatus(Byte value) {
        return LessonStatus.fromValue(value);
    }

    @Mappings({
            @Mapping(source = "planStatus",target = "planStatus",qualifiedByName = "mapToPlanStatus"),
            @Mapping(source = "status",target = "lessonStatus",qualifiedByName = "mapToLessonStatus"),
    })
    LearningLessonAggregate mapToAggregate(LearningLesson source);

    List<LearningLessonAggregate> mapToAggregateList(List<LearningLesson> sources);

}
