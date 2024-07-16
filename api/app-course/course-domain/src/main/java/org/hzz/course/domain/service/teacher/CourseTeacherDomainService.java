package org.hzz.course.domain.service.teacher;

import org.hzz.course.domain.entity.CourseTeacherEntity;

import java.util.List;

/**
 * 课程老师领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
public interface CourseTeacherDomainService {

    /**
     * 获取课程对应的老师
     * @param courseId 课程id
     * @return 老师列表 因为一个可能会有多个老师
     */
    List<CourseTeacherEntity> getTeachersOfCourse(Long courseId);
}
