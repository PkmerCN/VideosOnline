package org.hzz.learning.domain.service.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.learning.domain.aggregate.LearningLessonRecordAggregate;
import org.hzz.learning.domain.repository.LearnLessonRecordRepository;
import org.hzz.learning.domain.service.LearnLessonRecordDomainService;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Service
public class LearnLessonRecordDomainServiceImpl extends BaseDomainService<LearnLessonRecordRepository> implements LearnLessonRecordDomainService {
    @Override
    public LearningLessonRecordAggregate queryLearnLessonRecord(Long userId, Long courseId) {
        return null;
    }
}
