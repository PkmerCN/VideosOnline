package org.hzz.learning.domain.repository;

import org.hzz.learning.domain.entity.LearnRecordEntity;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
public interface LearnLessonRecordRepository {

   List<LearnRecordEntity> selectLearnLessonRecords(Long lessonId);
}
