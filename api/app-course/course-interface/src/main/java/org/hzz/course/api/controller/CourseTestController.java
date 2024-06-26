package org.hzz.course.api.controller;

import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.course.api.CourseTestApi;
import org.hzz.course.infrastructure.dao.mapper.CourseMapper;
import org.hzz.course.infrastructure.dao.mapper.CourseTestMapper;
import org.hzz.course.infrastructure.dao.po.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@RestController
public class CourseTestController extends BaseController implements CourseTestApi {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseTestMapper courseTestMapper;

    @Override
    public Result<Course> findCourse() {
        logger.info("准备进行查找course");
        Course course = courseMapper.selectByPrimaryKey(1L);
//        Course course = courseTestMapper.selectById(1L);
//        Course course = courseTestMapper.selectOne(1L);
        return success(course);
    }
}
