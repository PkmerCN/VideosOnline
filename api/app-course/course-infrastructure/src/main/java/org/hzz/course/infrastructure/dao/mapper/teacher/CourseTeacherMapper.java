package org.hzz.course.infrastructure.dao.mapper.teacher;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.course.infrastructure.dao.model.teacher.CourseTeacher;
import org.hzz.course.infrastructure.dao.model.teacher.CourseTeacherExample;

import java.util.List;

@Mapper
public interface CourseTeacherMapper {
    long countByExample(CourseTeacherExample example);

    int deleteByExample(CourseTeacherExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CourseTeacher row);

    int insertSelective(CourseTeacher row);

    List<CourseTeacher> selectByExample(CourseTeacherExample example);

    CourseTeacher selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") CourseTeacher row, @Param("example") CourseTeacherExample example);

    int updateByExample(@Param("row") CourseTeacher row, @Param("example") CourseTeacherExample example);

    int updateByPrimaryKeySelective(CourseTeacher row);

    int updateByPrimaryKey(CourseTeacher row);
}