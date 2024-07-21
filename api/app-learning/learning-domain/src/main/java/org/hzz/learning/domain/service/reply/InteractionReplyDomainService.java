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
     * 根据id更新属性，id放在InteractionReplyEntity
     * @param entity 要更新的实体
     */
    void updateEntity(InteractionReplyEntity entity);

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
     * @param isForAdmin 是否是admin端查询 true admin的分页。false 用户端的查询
     * @return 分页结果
     */
    PageResponse<InteractionReplyEntity> selectReplyPage(
            Long questionId,
            Boolean isForAdmin,
            PageQuery pageQuery);

    /**
     * 分页查询某个回答下的评论
     * @param answerId 回复id
     * @param pageQuery 分页查询条件
     * @param isForAdmin 是否是admin端查询 true admin的分页。false 用户端的查询
     * @return 分页查询
     */
    PageResponse<InteractionReplyEntity> selectCommentPage(
            Long questionId,
            Long answerId,
            Boolean isForAdmin,
            PageQuery pageQuery
    );

}
