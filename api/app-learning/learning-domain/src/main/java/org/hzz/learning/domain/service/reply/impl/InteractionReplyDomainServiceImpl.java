package org.hzz.learning.domain.service.reply.impl;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.service.BaseDomainService;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.repository.question.InteractionReplyRepository;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * 评论领域服务
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Service
public class InteractionReplyDomainServiceImpl
        extends BaseDomainService<InteractionReplyRepository>
        implements InteractionReplyDomainService {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<InteractionReplyEntity> getEntityByIds(Set<Long> ids) {
        List<InteractionReplyEntity> entities = repository.selectBatchIds(ids);
        if (CollUtil.isNotEmpty(entities)) {
            logger.info("查询到评论回复{}条", entities.size());
            return entities;
        }
        return Collections.emptyList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteReplyByQuestionId(Long questionId) {
        int i = repository.deleteByQuestionId(questionId);
        if (i != 0) {
            logger.info("成功删除{}条回复", i);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void commitReply(InteractionReplyEntity entity) {
        int insert = repository.insertSelective(entity);
        if (logger.isInfoEnabled() && insert != 0) {
            String msg = Boolean.TRUE.equals(entity.isComment()) ?
                    "评论" : "回答";
            logger.info("成功提交{}个{}",insert,msg);
        }
    }
}
