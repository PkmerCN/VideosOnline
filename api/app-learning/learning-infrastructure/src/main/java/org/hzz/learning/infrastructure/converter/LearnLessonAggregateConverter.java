package org.hzz.learning.infrastructure.converter;

import org.hzz.core.converter.BaseConverter;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.learning.domain.enums.LessonStatus;
import org.hzz.learning.domain.enums.PlanStatus;
import org.hzz.learning.infrastructure.dao.entity.LearningLesson;
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
public interface LearnLessonAggregateConverter extends BaseConverter {

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
            @Mapping(source = "status",target = "status",qualifiedByName = "mapToLessonStatus"),
            @Mapping(source = "createTime",target = "createTime",qualifiedByName = "mapLocalDateTimeToDate"),
            @Mapping(source = "expireTime",target = "expireTime",qualifiedByName = "mapLocalDateTimeToDate")
    })
    LearningLessonAggregate mapToAggregate(LearningLesson source);

    List<LearningLessonAggregate> mapToAggregateList(List<LearningLesson> sources);

}
