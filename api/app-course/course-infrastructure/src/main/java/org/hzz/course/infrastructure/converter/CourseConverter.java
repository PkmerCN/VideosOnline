package org.hzz.course.infrastructure.converter;

import org.hzz.course.domain.entity.CourseSimpleInfoDto;
import org.hzz.course.infrastructure.dao.po.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


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
        return date != null ? LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()) : null;
    }

    @Named("mapLocalDateTimeToDate")
    default Date mapLocalDateTimeToDate(LocalDateTime dateTime) {
        return dateTime != null ? Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant()) : null;
    }

    @Mappings({
            @Mapping(source = "free",target = "dd",qualifiedByName = "mapByteToBoolean"),
            @Mapping(source = "purchaseEndTime",target = "purchaseEndTime",qualifiedByName = "mapDateToLocalDateTime")
    })
    CourseSimpleInfoDto mapToCourseSimpleInfoDto(Course course);

    @Mappings({
            @Mapping(source = "free",target = "dd",qualifiedByName = "mapBooleanToByte"),
            @Mapping(source = "purchaseEndTime",target = "purchaseEndTime",qualifiedByName = "mapLocalDateTimeToDate")
    })
    Course mapToCourse(CourseSimpleInfoDto dto);
}
