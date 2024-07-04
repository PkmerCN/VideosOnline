package org.hzz.learning.domain.service.impl;

import lombok.Setter;
import org.hzz.common.date.DateUtil;
import org.hzz.core.exception.db.AppDbEntityNotFoundException;
import org.hzz.core.exception.db.AppDbInsertException;
import org.hzz.core.service.BaseDomainService;
import org.hzz.learning.domain.aggregate.LearningLessonRecordAggregate;
import org.hzz.learning.domain.entity.IdAndNumEntity;
import org.hzz.learning.domain.entity.LearnRecordEntity;
import org.hzz.learning.domain.entity.LearningLessonEntity;
import org.hzz.learning.domain.repository.LearnLessonRecordRepository;
import org.hzz.learning.domain.service.LearnLessonDomainService;
import org.hzz.learning.domain.service.LearnLessonRecordDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        logger.info("成功插入{}条记录",i);
        if(i == 0){
            throw new AppDbInsertException("提交视频播放进度失败");
        }
    }

    @Override
    public void updateRecord(LearnRecordEntity entity) {
        int i = repository.updateRecord(entity);
        logger.info("更新{}条记录",i);
        if(i == 0){
            throw new AppDbEntityNotFoundException("更新学习记录失败");
        }
    }

    @Override
    public LearnRecordEntity findLearnRecord(Long lessonId, Long sectionId) {
        return repository.selectLearnLessonRecord(lessonId,sectionId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<IdAndNumEntity> countUserWeekLearnSections(Long userId) {

        LocalDateTime startOfWeek = DateUtil.getStartOfWeek();
        LocalDateTime endOfWeek = DateUtil.getEndOfWeek();

        return repository.countUserfinishedSections(userId, startOfWeek, endOfWeek);
    }
}
