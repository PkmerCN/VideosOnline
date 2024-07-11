package org.hzz.learning.infrastructure.dao.mapper.question;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionQuestion;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionQuestionExample;

public interface InteractionQuestionMapper {
    long countByExample(InteractionQuestionExample example);

    int deleteByExample(InteractionQuestionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InteractionQuestion row);

    int insertSelective(InteractionQuestion row);

    List<InteractionQuestion> selectByExample(InteractionQuestionExample example);

    InteractionQuestion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") InteractionQuestion row, @Param("example") InteractionQuestionExample example);

    int updateByExample(@Param("row") InteractionQuestion row, @Param("example") InteractionQuestionExample example);

    int updateByPrimaryKeySelective(InteractionQuestion row);

    int updateByPrimaryKey(InteractionQuestion row);
}