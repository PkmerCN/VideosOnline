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

   LearnRecordEntity selectLearnLessonRecord(Long lessonId,Long sectionId);

   /**
    * 插入一条记录
    * @param entity 学习记录实体
    * @return 插入条数
    */
   int saveLearnRecord(LearnRecordEntity entity);

   /**
    * 更新记录
    * @param entity 学习记录实体
    * @return 更新条数
    */
   int updateRecord(LearnRecordEntity entity);
}
