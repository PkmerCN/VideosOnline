package org.hzz.learning.domain.service.question.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.repository.question.InteractionQuestionRepository;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.springframework.stereotype.Service;

/**
 * 问答以系统领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Service
public class InteractionQuestionDomainServiceImpl
        extends BaseDomainService<InteractionQuestionRepository>
        implements InteractionQuestionDomainService {

    /**
     * {@inheritDoc}
     */
    @Override
    public void newQuestion(InteractionQuestionEntity entity) {
        int i = repository.insertSelective(entity);
        logger.info("提交{}个问题",i);
    }
}
