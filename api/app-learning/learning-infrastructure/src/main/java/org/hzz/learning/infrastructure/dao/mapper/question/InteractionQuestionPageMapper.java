package org.hzz.learning.infrastructure.dao.mapper.question;

import org.apache.ibatis.annotations.Mapper;
import org.hzz.core.mapper.PageMapper;
import org.hzz.learning.infrastructure.dao.entity.question.InteractionQuestion;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Mapper
public interface InteractionQuestionPageMapper extends PageMapper<InteractionQuestion> {
}
