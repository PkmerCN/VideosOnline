package org.hzz.learning.infrastructure.dao.mapper.question;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 扩展SQL
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Mapper
public interface InteractionQuestionExtMapper {

    //@Update("update interaction_question set answer_times = answer_times + 1,latest_answer_id = #{answerId} where id = #{id}")
    int updateAnswer(@Param("id") Long id, @Param("answerId") Long answerId);
}
