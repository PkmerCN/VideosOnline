package org.hzz.learning.infrastructure.repository.mybatis;

import lombok.Setter;
import org.hzz.learning.domain.repository.LearnLessonRepository;
import org.hzz.learning.domain.valueobject.EnrollerLesson;
import org.hzz.learning.infrastructure.dao.mapper.LearningLessonBatchMapper;
import org.hzz.learning.infrastructure.dao.mapper.LearningLessonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Repository
public class LearnLessonRepositoryImpl implements LearnLessonRepository {

    @Setter(onMethod_ = @Autowired)
    private LearningLessonMapper learningLessonMapper;
    @Setter(onMethod_ = @Autowired)
    private LearningLessonBatchMapper learningLessonBatchMapper;


    @Override
    public void saveBath(List<EnrollerLesson> lessonList) {
        //todo 转换
        learningLessonBatchMapper.saveBatch(null);
    }
}
