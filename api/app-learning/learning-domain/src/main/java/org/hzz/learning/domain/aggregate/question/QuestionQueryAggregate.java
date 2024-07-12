package org.hzz.learning.domain.aggregate.question;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.AggregateRoot;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.types.req.question.QuestionPageQuery;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
public class QuestionQueryAggregate implements AggregateRoot {
    private InteractionQuestionEntity entity;
    private QuestionPageQuery pageQuery;
}
