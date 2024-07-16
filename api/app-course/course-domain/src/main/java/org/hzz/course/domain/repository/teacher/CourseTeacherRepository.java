package org.hzz.course.domain.repository.teacher;

import org.hzz.course.domain.entity.CourseTeacherEntity;

import java.util.List;

/**
 * 课程老师repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
public interface CourseTeacherRepository {

    /**
     * 获取课程与教师关联表的信息
     * @param courseId 课程id
     * @return 课程关联的教师信息列表
     */
    List<CourseTeacherEntity> getTeachersByCourseId(Long courseId);
}
