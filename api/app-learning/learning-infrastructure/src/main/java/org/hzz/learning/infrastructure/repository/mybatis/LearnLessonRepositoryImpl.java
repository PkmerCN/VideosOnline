package org.hzz.learning.infrastructure.repository.mybatis;

import lombok.Setter;
import org.hzz.learning.domain.repository.LearnLessonRepository;
import org.hzz.learning.infrastructure.dao.mapper.LearningLessonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Repository
public class LearnLessonRepositoryImpl implements LearnLessonRepository {

    @Setter(onMethod_ = @Autowired)
    private LearningLessonMapper learningLessonMapper;


    @Override
    public void saveBath() {

    }
}
