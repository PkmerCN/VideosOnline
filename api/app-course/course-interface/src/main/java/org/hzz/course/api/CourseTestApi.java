package org.hzz.course.api;

import org.hzz.core.result.Result;
import org.hzz.course.infrastructure.dao.po.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@RequestMapping("/course-test")
public interface CourseTestApi {

    @GetMapping("/query")
    Result<Course> findCourse();
}
