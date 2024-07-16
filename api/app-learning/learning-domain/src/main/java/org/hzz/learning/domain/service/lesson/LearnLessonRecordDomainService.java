package org.hzz.learning.domain.service.lesson;

import org.hzz.learning.domain.aggregate.LearningLessonRecordAggregate;
import org.hzz.learning.domain.entity.IdAndNumEntity;
import org.hzz.learning.domain.entity.LearnRecordEntity;

import java.util.List;

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

    /**
     * 统计用户周已完成学习记录
     * @return
     */
    List<IdAndNumEntity> countUserWeekLearnSections(Long userId);
}
