package org.hzz.learning.domain.repository.reply;

import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.PageQuery;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;

import java.util.List;
import java.util.Set;

/**
 * 回答或者评论Repository
 * {@link org.hzz.learning.infrastructure.repository.mybatis.question.InteractionReplyRepositoryImpl}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
public interface InteractionReplyRepository {
    /**
     * 根据id列表查询
     * @param ids id集合
     * @return {@link InteractionReplyEntity} 列表
     */
    List<InteractionReplyEntity> selectBatchIds(Set<Long> ids);


    /**
     * 根据id查询评论或者回复
     * @param id id主键
     * @return 评论
     */
    InteractionReplyEntity selectById(Long id);

    /**
     * 根据问题id删除评论
     * @param questionId 问题id
     * @return 删除数目
     */
    int deleteByQuestionId(Long questionId);

    /**
     * 插入评论
     * @param entity 评论或者回复实体
     * @return 保存的记录数据
     */
    int insertSelective(InteractionReplyEntity entity);

    /**
     * 更新评论或者回复
     * @param entity 实体
     * @return 更新数目
     */
    int updateSelective(InteractionReplyEntity entity);



    /**
     * 处理回复的评论数量+1
     * @param id 评论的回复id
     * @return 影响的行
     */
    int incrReplyTimes(Long id);

    /**
     * 分页查询
     * @param pageQuery
     * @return
     */
    PageResponse<InteractionReplyEntity> selectPage(PageQuery pageQuery);


    /**
     * 支持批量更新字段，但是目前只支持likedTimes
     */
    int updateBatchByPrimarySelective(List<InteractionReplyEntity> list);

}
