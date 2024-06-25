package org.hzz.course.domain.service.impl;

import org.hzz.core.service.BaseAppService;
import org.hzz.course.domain.aggregate.CourseSimpleInfoListDto;
import org.hzz.course.domain.entity.CourseSimpleInfoDto;
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
    public List<CourseSimpleInfoDto> findCourseSimpleInfoList(CourseSimpleInfoListDto dto) {
        return repository.selectCourseSimpleInfoList(dto);
    }
}
