package org.hzz.learning.application.converter;

import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.learning.application.resp.CourseDto;
import org.hzz.learning.application.resp.LearnLessonDto;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Mapper(componentModel = "spring")
public interface LearnLessonDtoConverter {


    LearnLessonDto mapToLearnLessonDto(LearningLessonAggregate source);

    @Mappings({
            @Mapping(source = "sectionNum",target = "sections")
    })
    CourseDto mapToCourseDto(CourseEntity dto);

    List<LearnLessonDto> mapToDtos(List<LearningLessonAggregate> sources);
}
