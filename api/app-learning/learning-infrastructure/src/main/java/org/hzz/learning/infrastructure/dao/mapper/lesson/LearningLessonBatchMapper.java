package org.hzz.learning.infrastructure.dao.mapper.lesson;

import org.apache.ibatis.annotations.Mapper;
import org.hzz.learning.infrastructure.dao.entity.lesson.LearningLesson;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Mapper
public interface LearningLessonBatchMapper {

    void saveBatch(List<LearningLesson> list);
}
