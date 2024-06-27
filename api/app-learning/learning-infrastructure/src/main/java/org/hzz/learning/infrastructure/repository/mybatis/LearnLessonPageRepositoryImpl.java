package org.hzz.learning.infrastructure.repository.mybatis;

import lombok.Setter;
import org.hzz.core.repository.PageBaseRepository;
import org.hzz.learning.infrastructure.converter.LearnLessonAggregateConverter;
import org.hzz.learning.infrastructure.dao.entity.LearningLesson;
import org.hzz.learning.infrastructure.dao.mapper.LearningLessonMapper;
import org.hzz.learning.infrastructure.dao.mapper.LearningLessonPageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Repository
public class LearnLessonPageRepositoryImpl extends PageBaseRepository<LearningLessonPageMapper,
        LearningLesson,
        LearnLessonAggregateConverter> {




}
