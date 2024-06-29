package org.hzz.learning.domain.service.impl;

import lombok.Setter;
import org.hzz.core.service.BaseDomainService;
import org.hzz.learning.domain.aggregate.LearningLessonRecordAggregate;
import org.hzz.learning.domain.entity.LearnRecordEntity;
import org.hzz.learning.domain.entity.LearningLessonEntity;
import org.hzz.learning.domain.repository.LearnLessonRecordRepository;
import org.hzz.learning.domain.service.LearnLessonDomainService;
import org.hzz.learning.domain.service.LearnLessonRecordDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Service
public class LearnLessonRecordDomainServiceImpl extends BaseDomainService<LearnLessonRecordRepository> implements LearnLessonRecordDomainService {

    @Setter(onMethod_ = @Autowired)
    private LearnLessonDomainService learnLessonDomainService;

    @Override
    public LearningLessonRecordAggregate queryLearnLessonRecord(Long userId, Long courseId) {
        LearningLessonEntity learningLessonEntity = learnLessonDomainService.queryLesson(userId, courseId);
        List<LearnRecordEntity> learnRecordEntities = repository.selectLearnLessonRecords(learningLessonEntity.getId());

        return LearningLessonRecordAggregate.builder()
                .lesson(learningLessonEntity)
                .records(learnRecordEntities)
                .build();
    }

    @Override
    public void commitRecord(LearnRecordEntity entity) {
        int i = repository.saveLearnRecord(entity);
        if(i != 0){
            logger.info("成功插入{}条记录",i);
        }
    }
}
