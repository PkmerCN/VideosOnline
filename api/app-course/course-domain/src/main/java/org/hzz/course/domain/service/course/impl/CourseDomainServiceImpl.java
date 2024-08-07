package org.hzz.course.domain.service.course.impl;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.service.BaseAppService;
import org.hzz.course.domain.aggregate.CourseIdAggregate;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.domain.repository.CourseRepository;
import org.hzz.course.domain.service.course.CourseDomainService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * course领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Service
public class CourseDomainServiceImpl extends BaseAppService<CourseRepository> implements CourseDomainService {
    @Override
    public List<CourseEntity> findCourses(CourseIdAggregate dto) {
        return repository.selectCourseSimpleInfoList(dto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Long, CourseEntity> getMapCourseEntities(Set<Long> ids) {
        CourseIdAggregate aggregate = CourseIdAggregate.builder().ids(new ArrayList<>(ids)).build();
        List<CourseEntity> courses = findCourses(aggregate);

        if(CollUtil.isEmpty(courses)){
            return Collections.emptyMap();
        }

        return courses.stream().collect(
                Collectors.toMap(CourseEntity::getId,c -> c)
        );
    }

    @Override
    public CourseEntity findCourse(Long courseId) {
        CourseIdAggregate query = CourseIdAggregate.builder()
                .ids(List.of(courseId))
                .build();
        List<CourseEntity> courses = findCourses(query);
        if(CollUtil.isNotEmpty(courses)){
            return courses.get(0);
        }
        return null;
    }
}
