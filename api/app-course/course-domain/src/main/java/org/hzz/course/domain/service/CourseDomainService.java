package org.hzz.course.domain.service;

import org.hzz.course.domain.aggregate.CourseSimpleInfoListDto;
import org.hzz.course.domain.entity.CourseSimpleInfoDto;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
public interface CourseDomainService {

    List<CourseSimpleInfoDto> findCourseSimpleInfoList(CourseSimpleInfoListDto dto);
}
