package org.hzz.course.domain.service.teacher.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.course.domain.entity.CourseTeacherEntity;
import org.hzz.course.domain.repository.teacher.CourseTeacherRepository;
import org.hzz.course.domain.service.teacher.CourseTeacherDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Service
public class CourseTeacherDomainServiceImpl
        extends BaseDomainService<CourseTeacherRepository>
        implements CourseTeacherDomainService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CourseTeacherEntity> getTeachersOfCourse(Long courseId) {
        List<CourseTeacherEntity> teachers = repository.getTeachersByCourseId(courseId);
        logger.info("查询到课程 id = {} 对应的老师有{}位",courseId,teachers.size());
        return teachers;
    }
}
