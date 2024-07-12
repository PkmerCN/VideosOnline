package org.hzz.learning.domain.service.question;

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
}
