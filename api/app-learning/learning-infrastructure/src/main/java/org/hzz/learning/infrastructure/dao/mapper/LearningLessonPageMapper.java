package org.hzz.learning.infrastructure.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.hzz.core.mapper.PageMapper;
import org.hzz.learning.infrastructure.dao.po.LearningLesson;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Mapper
public interface LearningLessonPageMapper extends PageMapper<LearningLesson> {
}
