package org.hzz.course.infrastructure.repository.mybatis;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.repository.withmapper.BaseRepository;
import org.hzz.course.domain.aggregate.CourseIdAggregate;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.domain.repository.CourseRepository;
import org.hzz.course.infrastructure.converter.CourseConverter;
import org.hzz.course.infrastructure.dao.mapper.CourseMapper;
import org.hzz.course.infrastructure.dao.model.Course;
import org.hzz.course.infrastructure.dao.model.CourseExample;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Course表查询
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Component
public class CourseRepositoryImpl extends BaseRepository<CourseMapper, CourseConverter> implements CourseRepository {
    @Override
    public List<CourseEntity> selectCourseSimpleInfoList(CourseIdAggregate dto) {
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria criteria = courseExample.createCriteria();

        if(CollUtil.isNotEmpty(dto.getThirdCataIds())){
            criteria.andThirdCateIdIn(dto.getThirdCataIds());
        }

        if(CollUtil.isNotEmpty(dto.getIds())){
            criteria.andIdIn(dto.getIds());
        }

        List<Course> courses = mapper.selectByExample(courseExample);
        logger.info("查询出: {} 个course 记录",courses.size());
        return converter.mapToCourseSimpleInfoDtoList(courses);
    }
}
