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

   /**
    * 插入一条记录
    * @param entity 学习记录实体
    * @return 插入条数
    */
   int saveLearnRecord(LearnRecordEntity entity);
}
