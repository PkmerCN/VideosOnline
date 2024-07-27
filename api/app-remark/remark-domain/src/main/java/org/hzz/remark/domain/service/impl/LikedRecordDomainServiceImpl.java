package org.hzz.remark.domain.service.impl;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.core.service.BaseDomainService;
import org.hzz.rabbitmq.constants.rabbitmq.VideoMqConstants;
import org.hzz.rabbitmq.core.RabbitMQHelper;
import org.hzz.remark.domain.entity.LikedRecordEntity;
import org.hzz.remark.domain.repository.LikedRecordRepository;
import org.hzz.remark.domain.service.LikedRecordDomainService;
import org.hzz.remark.types.BizType;
import org.hzz.remark.types.LikedTimesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Service
//@Primary
public class LikedRecordDomainServiceImpl
        extends BaseDomainService<LikedRecordRepository>
        implements LikedRecordDomainService {

    @Setter(onMethod_ = @Autowired)
    private RabbitMQHelper rabbitMQHelper;

    /**
     * {@inheritDoc}
     *
     * @param userId  用户
     * @param bizId   业务id
     * @param bizType 业务类型
     */
    @Override
    public void like(Long userId, Long bizId, BizType bizType) {
        try {
            LikedRecordEntity entity = new LikedRecordEntity();
            entity.setBizId(bizId).setBizType(bizType).setUserId(userId);
            int insert = repository.insert(entity);
            if (insert == 1) {
                logger.info("插入点赞成功");
                // rabbitmq
                updateLikedTimes(bizId, bizType);
            }
        } catch (DuplicateKeyException e) {
            logger.info(e.getMessage());
            throw new BadRequestException(AppStatusImpl.REPEAT_OPERATION);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param userId 用户id
     * @param bizId  业务id
     */
    @Override
    public void cancel(Long userId, Long bizId, BizType bizType) {
        Optional<LikedRecordEntity> entityOptional = repository.selectOne(userId, bizId);

        LikedRecordEntity entity = entityOptional.orElseThrow(
                () -> new BadRequestException(AppStatusImpl.ARG_INVALID));
        logger.info("准备删除id = {}点赞记录", entity.getId());
        int delete = repository.delete(entity.getId());
        if (delete == 1) {
            logger.info("删除点赞记录{}条", delete);
            // rabbitmq
            updateLikedTimes(bizId, bizType);
        }
    }

    /**
     * {@inheritDoc}
     * @param userId 用户id
     * @param bizIds 业务id集合
     * @return 用户已经点赞的集合，范围限定在传入的参数bizIds
     */
    @Override
    public Set<Long> checkUserLikeBizId(Long userId, Set<Long> bizIds) {
        return repository.checkUserLikeBizId(userId,bizIds);
    }

    /**
     * rabbitMQ异步更新数据
     *
     * @param bizId   业务id
     * @param bizType 业务类型
     */
    private void updateLikedTimes(Long bizId, BizType bizType) {
        long likedTimes = repository.count(bizId);
        LikedTimesDto msgBody = new LikedTimesDto();
        msgBody.setLikedTimes(likedTimes)
                .setBizId(bizId);

        /**
         * 接收消息的处理逻辑
         * {@link org.hzz.learning.trigger.mq.rabbitmq.consumer.ReplyLikeTimesListener}
         */
        rabbitMQHelper.sendAsync(
                VideoMqConstants.Exchange.LIKE_RECORD_EXCHANGE,
                StrUtil.format(VideoMqConstants.Key.LIKED_TIMES_KEY_TEMPLATE, bizType.getValue()),
                List.of(msgBody)
        );
    }
}
