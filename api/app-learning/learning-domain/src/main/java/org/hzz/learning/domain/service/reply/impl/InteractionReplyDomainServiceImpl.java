package org.hzz.learning.domain.service.reply.impl;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.FilterCondition;
import org.hzz.core.page.query.FilterCondition.Operation;
import org.hzz.core.page.query.PageQuery;
import org.hzz.core.page.query.SortOrder;
import org.hzz.core.service.BaseDomainService;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.repository.reply.InteractionReplyRepository;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.springframework.stereotype.Service;

import static org.hzz.learning.types.constants.InteractionReplyFields.*;

import java.util.ArrayList;
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
    public InteractionReplyEntity getEntityById(Long id) {
        InteractionReplyEntity entity = repository.selectById(id);
        if (entity != null && logger.isInfoEnabled()) {
            logger.info("成功获取到评论");
        }
        return entity;
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
            logger.info("成功提交{}个{}", insert, msg);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incrReplyTimes(Long id) {
        InteractionReplyEntity oldEntity = this.getEntityById(id);
        Integer oldTimes = oldEntity.getReplyTimes();

        // 通过数据库update reply_times = reply_times + 1
        int i = repository.incrReplyTimes(id);

        InteractionReplyEntity newEntity = this.getEntityById(id);
        Integer newTimes = newEntity.getReplyTimes();

        // todo 有并发问题，所以用数据库的update reply_times = reply_times + 1,
        // entity.setReplyTimes(older + 1);
        // int i = repository.updateSelective(entity);


        if (logger.isInfoEnabled() && i != 0) {
            logger.info("成功增加评论次数 {} -> {}", oldTimes,newTimes);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageResponse<InteractionReplyEntity> selectReplyPage(Long questionId, PageQuery pageQuery) {
        final Long TopAnswerId = 0L;
        List<FilterCondition> filters = new ArrayList<>();
        // todo freemark 生成一个常量类。字段名称

        // question_id
        filters.add(new FilterCondition(QUESTION_ID,Operation.Equal,questionId));
        // 一级评论
        filters.add(new FilterCondition(ANSWER_ID,Operation.Equal,TopAnswerId));

        // 按照点赞，创建时间
        List<SortOrder> sortOrders = new ArrayList<>();
        sortOrders.add(new SortOrder(LIKED_TIMES,false));
        sortOrders.add(new SortOrder(CREATE_TIME,false));


        pageQuery.setFilters(filters);
        pageQuery.setSortOrders(sortOrders);

        return repository.selectPage(pageQuery);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageResponse<InteractionReplyEntity> selectCommentPage(Long answerId, PageQuery pageQuery) {
        return null;
    }
}
