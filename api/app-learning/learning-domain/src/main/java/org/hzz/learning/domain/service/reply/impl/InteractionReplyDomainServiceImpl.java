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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.hzz.learning.types.constants.InteractionReplyFields.*;

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
    public void updateEntity(InteractionReplyEntity entity) {
        int i = repository.updateSelective(entity);
        logger.info("更新{}条数据",i);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateLikedTimesBatchByIds(List<InteractionReplyEntity> entities) {
        if(entities.isEmpty()) return;
        int i = repository.updateBatchByPrimarySelective(entities);
        logger.info("批量更新{}条数据",i);
    }

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
            logger.info("成功增加评论次数 {} -> {}", oldTimes, newTimes);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PageResponse<InteractionReplyEntity> selectReplyPage(
            Long questionId,
            Boolean isForAdmin,
            PageQuery pageQuery) {
        final Long TopAnswerId = 0L;

        setDefaulPageSelecttFiltersAndSortOrder(
                questionId,
                TopAnswerId,
                isForAdmin,
                pageQuery);

        return repository.selectPage(pageQuery);
    }



    /**
     * {@inheritDoc}
     */
    @Override
    public PageResponse<InteractionReplyEntity> selectCommentPage(Long questionId,
                                                                  Long answerId,
                                                                  Boolean isForAdmin,
                                                                  PageQuery pageQuery) {
        setDefaulPageSelecttFiltersAndSortOrder(
                questionId,
                answerId,
                isForAdmin,
                pageQuery
        );
        return repository.selectPage(pageQuery);
    }


    /**
     * 设置分页查询默认条件过滤以及排序
     *
     * @param questionId 问题ID
     * @param answerId 问题id
     * @param pageQuery 分页
     */
    private PageQuery setDefaulPageSelecttFiltersAndSortOrder(Long questionId,
                                                         Long answerId,
                                                         Boolean isForAdmin,
                                                         PageQuery pageQuery) {
        List<FilterCondition> filters = new ArrayList<>();

        // question_id
        filters.add(new FilterCondition(QUESTION_ID, Operation.Equal, questionId));
        // 一级评论
        filters.add(new FilterCondition(ANSWER_ID, Operation.Equal, answerId));
        if(!isForAdmin){
            // admin端全部查询，就没有这个条件
            // 用户端只查询没有隐藏的回复
            filters.add(new FilterCondition(HIDDEN, Operation.Equal, false));
        }


        // 按照点赞，创建时间
        List<SortOrder> sortOrders = new ArrayList<>();
        sortOrders.add(new SortOrder(LIKED_TIMES, false));
        sortOrders.add(new SortOrder(CREATE_TIME, false));

        // 设置
        pageQuery.setFilters(filters);
        pageQuery.setSortOrders(sortOrders);

        return pageQuery;
    }
}
