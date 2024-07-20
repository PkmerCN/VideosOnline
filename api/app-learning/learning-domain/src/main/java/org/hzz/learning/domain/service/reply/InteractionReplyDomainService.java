package org.hzz.learning.domain.service.reply;

import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.PageQuery;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;

import java.util.List;
import java.util.Set;

/**
 * 评论领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
public interface InteractionReplyDomainService {
    /**
     * 获取评论
     * @param ids id列表
     * @return {@link InteractionReplyEntity}列表
     */
    List<InteractionReplyEntity> getEntityByIds(Set<Long> ids);

    /**
     * 获取评论
     * @param id 评论id
     * @return 评论
     */
    InteractionReplyEntity getEntityById(Long id);

    /**
     * 删除问题下的所有评论回复
     * @param questionId 问题id
     */
    void deleteReplyByQuestionId(Long questionId);

    /**
     * 提交回答或者评论
     * @param entity 评论
     */
    void commitReply(InteractionReplyEntity entity);

    /**
     * 增加该评论的评论次数
     * @param id 评论主键id
     */
    void incrReplyTimes(Long id);

    /**
     * 分页查询问题下的回答
     * @param questionId 问题id
     * @param pageQuery 分页查询条件
     * @return 分页结果
     */
    PageResponse<InteractionReplyEntity> selectReplyPage(
            Long questionId,
            PageQuery pageQuery);

    /**
     * 分页查询某个回答下的评论
     * @param answerId 回复id
     * @param pageQuery 分页查询条件
     * @return 分页查询
     */
    PageResponse<InteractionReplyEntity> selectCommentPage(
            Long questionId,
            Long answerId,
            PageQuery pageQuery
    );

}
