package org.hzz.remark.domain.service;

import org.hzz.ddd.core.domain.shared.service.DomainService;
import org.hzz.remark.types.BizType;

/**
 * 点赞领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
public interface LikedRecordDomainService extends DomainService {

    /**
     * 点赞
     * @param userId 用户
     * @param bizId 业务id
     * @param bizType 业务类型
     */
    void like(Long userId, Long bizId, BizType bizType);

    /**
     * 取消点赞
     * @param userId 用户id
     * @param bizId 业务id
     */
    void cancel(Long userId,Long bizId);
}
