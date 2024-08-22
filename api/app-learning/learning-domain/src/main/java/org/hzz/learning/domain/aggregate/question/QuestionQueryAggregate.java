package org.hzz.learning.domain.aggregate.question;

import lombok.Data;
import io.gitee.pkmer.convention.page.query.PageQuery;
import io.gitee.pkmer.ddd.shared.AggregateRoot;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
public class QuestionQueryAggregate implements AggregateRoot {
    private InteractionQuestionEntity entity;
    private PageQuery pageQuery;
}
