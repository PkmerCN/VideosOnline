package org.hzz.learning.infrastructure.repository.mybatis.question;

import lombok.Setter;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.repository.question.InteractionQuestionRepository;
import org.hzz.learning.infrastructure.dao.mapper.question.InteractionQuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 问答表repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Repository
public class InteractionQuestionRepositoryImpl implements InteractionQuestionRepository {

    @Setter(onMethod_ = {@Autowired})
    private InteractionQuestionMapper interactionQuestionMapper;
    @Override
    public int insertSelective(InteractionQuestionEntity entity) {

        return 0;

    }
}
