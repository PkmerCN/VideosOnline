package org.hzz.course.infrastructure.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.hzz.course.infrastructure.dao.po.Course;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Mapper
public interface CourseTestMapper {

    @Select("select * from course where id = #{id}")
    public Course selectById(@Param("id")Long id);

    Course selectOne(@Param("id")Long id);
}
