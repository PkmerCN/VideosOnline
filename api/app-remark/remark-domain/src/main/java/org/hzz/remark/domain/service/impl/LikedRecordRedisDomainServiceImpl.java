package org.hzz.remark.domain.service.impl;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.collection.CollUtil;
import org.hzz.rabbitmq.constants.rabbitmq.VideoMqConstants;
import org.hzz.rabbitmq.core.RabbitMQHelper;
import org.hzz.remark.constants.RedisConstants;
import org.hzz.remark.domain.service.LikedRecordDomainService;
import org.hzz.remark.types.BizType;
import org.hzz.remark.types.LikedTimesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 使用redis作为存储
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/26
 */
@Primary
@Service("likedRecordRedisDomainService")
@Slf4j
public class LikedRecordRedisDomainServiceImpl implements LikedRecordDomainService {

    @Setter(onMethod_ = @Autowired)
    private RedisTemplate<String,String> redisTemplate;

    @Setter(onMethod_ = @Autowired)
    private RabbitMQHelper rabbitMQHelper;

    @Override
    public void like(Long userId, Long bizId, BizType bizType) {
        /**
         * redis set 涉及 QA:业务id -> 用户id
         */
        Long result = redisTemplate.opsForSet().add(
                getLikeRecordKey(bizId),
                userId.toString()
        );

        log.info("点赞记录下入redis");
        if(result != null && result > 0){
            // 更新点赞数量
            updateLikedTimes(bizId,bizType);
        }
    }

    @Override
    public void cancel(Long userId, Long bizId, BizType bizType) {
        Long remove = redisTemplate.opsForSet().remove(
                getLikeRecordKey(bizId),
                userId.toString()
        );
        if(remove != null && remove != 0L){
            log.info("删除成功");
            // 更新点赞数量
            updateLikedTimes(bizId,bizType);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<Long> checkUserLikeBizId(Long userId, Set<Long> bizIds) {
        log.info("检查用户点赞业务");

        List<Long> idList = new ArrayList<>(bizIds);
        List<Object> results = redisTemplate.executePipelined(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations operations) throws DataAccessException {
                for (Long bizId : idList) {
                    operations.opsForSet().isMember(getLikeRecordKey(bizId), userId.toString());
                }
                // 返回 null 因为我们不需要在这里返回实际的结果
                return null;
            }
        });


        Set<Long> collect = IntStream.range(0, results.size())
                .filter(i -> (boolean) results.get(i))
                .mapToObj(idList::get)
                .collect(Collectors.toSet());

        log.info("用户点赞的查询是{}条，实际点赞的是{}条",idList.size(),collect.size());
        return collect;
    }

    /**
     * 更新redis zset 点赞数量
     * @param bizId
     * @param bizType
     */
    private void updateLikedTimes(Long bizId, BizType bizType){


        // 统计数量
        Long size = redisTemplate.opsForSet().size(getLikeRecordKey(bizId));
        if(size == null) return;

        /**
         * redis zset 数据结构，为了做定时任务持久化
         * liked:times:QA -> 业务id (score: 30点赞数)
         */
        redisTemplate.opsForZSet().add(
                StrUtil.format(RedisConstants.LIKES_TIMES_KEY,bizType.getValue()),
                bizId.toString(),
                size
        );
    }

    /**
     * Redis set 的key 如：QA:业务id
     */
    private String getLikeRecordKey(Long bizId){
        return StrUtil.format(RedisConstants.TEMPLATE_KEY,bizId);
    }


    /**
     * zset
     * liked:times:QA -> 业务id (score点赞数量3)
     * @param bizType 业务类型
     * @param count 每个业务迁移的数量
     */
    public void readLikedTimesAndSendMsg(String bizType,Long count){
        // ZPOPMIN key [count]
        Set<ZSetOperations.TypedTuple<String>> typedTuples = redisTemplate.opsForZSet().popMin(
                StrUtil.format(RedisConstants.LIKES_TIMES_KEY, bizType),
                count
        );

        log.info("正在处理{}业务，一共{}条",bizType,typedTuples.size());

        List<LikedTimesDto> body = new ArrayList<>();
        for(ZSetOperations.TypedTuple<String> tuple: typedTuples){
            LikedTimesDto dto = new LikedTimesDto();
            dto.setBizId(Long.parseLong(Objects.requireNonNull(tuple.getValue())));
            dto.setLikedTimes(Objects.requireNonNull(tuple.getScore()).longValue());
            body.add(dto);
        }
        sendMqMsg(body,bizType);
    }

    /**
     * {@link org.hzz.learning.trigger.mq.rabbitmq.consumer.ReplyLikeTimesListener}
     */
    private void sendMqMsg(List<LikedTimesDto> msg,String bizType){
        if(CollUtil.isEmpty(msg)){
            log.info("消息为空不发送");
            return;
        }
        rabbitMQHelper.send(
                VideoMqConstants.Exchange.LIKE_RECORD_EXCHANGE,
                StrUtil.format(VideoMqConstants.Key.LIKED_TIMES_KEY_TEMPLATE,bizType),
                msg
        );
    }

}
