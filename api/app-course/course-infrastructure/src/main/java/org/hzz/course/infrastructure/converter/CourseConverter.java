package org.hzz.course.infrastructure.converter;

import org.hzz.common.date.DateUtil;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.infrastructure.dao.po.Course;
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
public interface CourseConverter {

    @Named("mapByteToBoolean")
    default Boolean mapByteToBoolean(Byte byteValue){
        return byteValue != null && byteValue != 0;
    }

    @Named("mapBooleanToByte")
    default Byte mapBooleanToByte(Boolean booleanValue) {
        return booleanValue != null && booleanValue ? (byte) 1 : (byte) 0;
    }

    @Named("mapDateToLocalDateTime")
    default LocalDateTime mapDateToLocalDateTime(Date date) {
        return DateUtil.changeDateToLocalDateTime(date);
    }

    @Named("mapLocalDateTimeToDate")
    default Date mapLocalDateTimeToDate(LocalDateTime dateTime) {
        return DateUtil.changeLocalDateTimeToDate(dateTime);
    }

    @Mappings({
            @Mapping(source = "free",target = "free",qualifiedByName = "mapByteToBoolean"),
            @Mapping(source = "purchaseEndTime",target = "purchaseEndTime",qualifiedByName = "mapDateToLocalDateTime")
    })
    CourseEntity mapToCourseSimpleInfoDto(Course course);

    List<CourseEntity> mapToCourseSimpleInfoDtoList(List<Course> courses);

    @Mappings({
            @Mapping(source = "free",target = "free",qualifiedByName = "mapBooleanToByte"),
            @Mapping(source = "purchaseEndTime",target = "purchaseEndTime",qualifiedByName = "mapLocalDateTimeToDate")
    })
    Course mapToCourse(CourseEntity dto);
}
