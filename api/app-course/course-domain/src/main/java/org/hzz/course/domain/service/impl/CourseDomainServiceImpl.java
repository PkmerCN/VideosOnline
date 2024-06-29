package org.hzz.course.domain.service.impl;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.service.BaseAppService;
import org.hzz.course.domain.aggregate.CourseSimpleInfoListDto;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.domain.repository.CourseRepository;
import org.hzz.course.domain.service.CourseDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * course领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Service
public class CourseDomainServiceImpl extends BaseAppService<CourseRepository> implements CourseDomainService {
    @Override
    public List<CourseEntity> findCourses(CourseSimpleInfoListDto dto) {
        return repository.selectCourseSimpleInfoList(dto);
    }

    @Override
    public CourseEntity findCourse(Long courseId) {
        CourseSimpleInfoListDto query = CourseSimpleInfoListDto.builder()
                .ids(List.of(courseId))
                .build();
        List<CourseEntity> courses = findCourses(query);
        if(CollUtil.isNotEmpty(courses)){
            return courses.get(0);
        }
        return null;
    }
}
