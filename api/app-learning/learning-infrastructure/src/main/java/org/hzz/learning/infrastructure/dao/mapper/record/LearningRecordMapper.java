package org.hzz.learning.infrastructure.dao.mapper.record;

import org.apache.ibatis.annotations.Param;
import org.hzz.learning.infrastructure.dao.entity.record.LearningRecord;
import org.hzz.learning.infrastructure.dao.entity.record.LearningRecordExample;

import java.util.List;

public interface LearningRecordMapper {
    long countByExample(LearningRecordExample example);

    int deleteByExample(LearningRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(LearningRecord row);

    int insertSelective(LearningRecord row);

    List<LearningRecord> selectByExample(LearningRecordExample example);

    LearningRecord selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") LearningRecord row, @Param("example") LearningRecordExample example);

    int updateByExample(@Param("row") LearningRecord row, @Param("example") LearningRecordExample example);

    int updateByPrimaryKeySelective(LearningRecord row);

    int updateByPrimaryKey(LearningRecord row);
}