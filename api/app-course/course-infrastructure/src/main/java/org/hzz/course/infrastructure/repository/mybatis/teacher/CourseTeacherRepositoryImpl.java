package org.hzz.course.infrastructure.repository.mybatis.teacher;

import org.hzz.common.tree.BaseConverter;
import org.hzz.core.repository.nomapper.BaseRepository;
import org.hzz.course.domain.entity.CourseTeacherEntity;
import org.hzz.course.domain.repository.teacher.CourseTeacherRepository;
import org.hzz.course.infrastructure.dao.mapper.teacher.CourseTeacherMapper;
import org.hzz.course.infrastructure.dao.model.teacher.CourseTeacher;
import org.hzz.course.infrastructure.dao.model.teacher.CourseTeacherExample;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Repository
public class CourseTeacherRepositoryImpl
    extends BaseRepository<CourseTeacherMapper>
        implements CourseTeacherRepository {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CourseTeacherEntity> getTeachersByCourseId(Long courseId) {
        CourseTeacherExample example = new CourseTeacherExample();
        example.createCriteria().andCourseIdEqualTo(courseId);

        List<CourseTeacher> courseTeachers = mapper.selectByExample(example);

        return CourseTeacherConverter.INSTANCE.covertToList(courseTeachers);
    }

    @Mapper
    interface CourseTeacherConverter extends BaseConverter<CourseTeacherEntity,CourseTeacher>{
        CourseTeacherConverter INSTANCE = Mappers.getMapper(CourseTeacherConverter.class);
    }

}
