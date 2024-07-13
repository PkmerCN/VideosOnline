package org.hzz.course.infrastructure.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.course.infrastructure.dao.model.Course;
import org.hzz.course.infrastructure.dao.model.CourseExample;

import java.util.List;
@Mapper
public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Course row);

    int insertSelective(Course row);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Course row, @Param("example") CourseExample example);

    int updateByExample(@Param("row") Course row, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course row);

    int updateByPrimaryKey(Course row);
}