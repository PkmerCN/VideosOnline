package org.hzz.remark.domain.service.impl;

import lombok.Setter;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.core.service.BaseDomainService;
import org.hzz.rabbitmq.core.RabbitMQHelper;
import org.hzz.remark.domain.entity.LikedRecordEntity;
import org.hzz.remark.domain.repository.LikedRecordRepository;
import org.hzz.remark.domain.service.LikedRecordDomainService;
import org.hzz.remark.types.BizType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Service
public class LikedRecordDomainServiceImpl
        extends BaseDomainService<LikedRecordRepository>
        implements LikedRecordDomainService {

    @Setter(onMethod_ = @Autowired)
    private RabbitMQHelper rabbitMQHelper;

    /**
     * {@inheritDoc}
     * @param userId 用户
     * @param bizId 业务id
     * @param bizType 业务类型
     */
    @Override
    public void like(Long userId, Long bizId, BizType bizType) {
        LikedRecordEntity entity = new LikedRecordEntity();
        entity.setBizId(bizId).setBizType(bizType).setUserId(userId);
        int insert = repository.insert(entity);
        if (insert == 1) {
            logger.info("插入点赞成功");
        }

        // todo rabbitmq
    }

    /**
     * {@inheritDoc}
     * @param userId 用户id
     * @param bizId 业务id
     */

    @Override
    public void cancel(Long userId, Long bizId) {
        Optional<LikedRecordEntity> entityOptional = repository.selectOne(userId, bizId);

        LikedRecordEntity entity = entityOptional.orElseThrow(
                () -> new BadRequestException(AppStatusImpl.ARG_INVALID));
        logger.info("准备删除id = {}点赞记录", entity.getId());
        int delete = repository.delete(entity.getId());
        if (delete == 1) {
            logger.info("删除点赞记录{}条", delete);
        }

        // todo rabbitmq
    }
}
