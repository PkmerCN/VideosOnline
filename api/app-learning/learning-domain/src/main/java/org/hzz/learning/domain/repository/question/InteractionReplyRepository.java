package org.hzz.learning.domain.repository.question;

import org.hzz.learning.domain.entity.question.InteractionReplyEntity;

import java.util.List;
import java.util.Set;

/**
 * 评论Repository
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
     * 根据问题id删除评论
     * @param questionId 问题id
     * @return 删除数目
     */
    int deleteByQuestionId(Long questionId);
}
