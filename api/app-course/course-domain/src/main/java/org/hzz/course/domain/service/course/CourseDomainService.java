package org.hzz.course.domain.service.course;

import org.hzz.course.domain.aggregate.CourseIdAggregate;
import org.hzz.course.domain.entity.CourseEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
public interface CourseDomainService {

    List<CourseEntity> findCourses(CourseIdAggregate dto);

    /**
     * 获取课程详情
     * @param ids 课程id集合
     * @return Map key为id，value为课程
     */
    Map<Long,CourseEntity> getMapCourseEntities(Set<Long> ids);

    CourseEntity findCourse(Long courseId);


}
