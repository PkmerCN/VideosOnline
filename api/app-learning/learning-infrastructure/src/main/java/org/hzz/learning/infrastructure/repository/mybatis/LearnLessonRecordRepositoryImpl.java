package org.hzz.learning.infrastructure.repository.mybatis;

import cn.hutool.core.bean.BeanUtil;
import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.learning.domain.entity.LearnRecordEntity;
import org.hzz.learning.domain.repository.LearnLessonRecordRepository;
import org.hzz.learning.infrastructure.dao.entity.record.LearningRecord;
import org.hzz.learning.infrastructure.dao.entity.record.LearningRecordExample;
import org.hzz.learning.infrastructure.dao.mapper.record.LearningRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Repository
public class LearnLessonRecordRepositoryImpl implements LearnLessonRecordRepository {
    @Setter(onMethod_ = @Autowired)
    private LearningRecordMapper learningRecordMapper;

    @Override
    public List<LearnRecordEntity> selectLearnLessonRecords(Long lessonId) {
        LearningRecordExample example = new LearningRecordExample();
        example.createCriteria()
                .andLessonIdEqualTo(lessonId);
        List<LearningRecord> learningRecords = learningRecordMapper.selectByExample(example);
        return BeanUtil.copyToList(learningRecords, LearnRecordEntity.class);
    }

    @Override
    public LearnRecordEntity selectLearnLessonRecord(Long lessonId, Long sectionId) {
        LearningRecordExample example = new LearningRecordExample();
        example.createCriteria()
                .andLessonIdEqualTo(lessonId)
                .andSectionIdEqualTo(sectionId);
        List<LearningRecord> learningRecords = learningRecordMapper.selectByExample(example);
        if(CollUtil.isNotEmpty(learningRecords)){
           return BeanUtil.copyProperties(learningRecords.get(0),LearnRecordEntity.class);
        }
        return null;
    }

    @Override
    public int saveLearnRecord(LearnRecordEntity entity) {
        LearningRecord learningRecord = BeanUtil.copyProperties(entity, LearningRecord.class);

        return learningRecordMapper.insertSelective(learningRecord);
    }
}
