package org.hzz.course.infrastructure.repository.mybatis;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.repository.BaseRepository;
import org.hzz.course.domain.aggregate.CourseSimpleInfoListDto;
import org.hzz.course.domain.entity.CourseSimpleInfoDto;
import org.hzz.course.domain.repository.CourseRepository;
import org.hzz.course.infrastructure.converter.CourseConverter;
import org.hzz.course.infrastructure.dao.mapper.CourseMapper;
import org.hzz.course.infrastructure.dao.po.Course;
import org.hzz.course.infrastructure.dao.po.CourseExample;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Component
public class CourseRepositoryImpl extends BaseRepository<CourseMapper, CourseConverter> implements CourseRepository {
    @Override
    public List<CourseSimpleInfoDto> selectCourseSimpleInfoList(CourseSimpleInfoListDto dto) {
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
