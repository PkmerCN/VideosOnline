package org.hzz.learning.domain.service;

import org.hzz.learning.domain.aggregate.LearningLessonRecordAggregate;
import org.hzz.learning.domain.entity.LearnRecordEntity;

/**
 * 课程学习记录领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
public interface LearnLessonRecordDomainService {

    LearningLessonRecordAggregate queryLearnLessonRecord(Long userId, Long courseId);

    void commitRecord(LearnRecordEntity entity);

    void updateRecord(LearnRecordEntity entity);

    LearnRecordEntity findLearnRecord(Long lessonId,Long sectionId);
}
