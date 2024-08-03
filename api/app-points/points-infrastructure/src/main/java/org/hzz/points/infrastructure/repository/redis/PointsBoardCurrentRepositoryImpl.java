package org.hzz.points.infrastructure.repository.redis;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.date.DateUtil;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.core.page.query.PageQuery;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.domain.repository.PointsBoardCurrentRepository;
import org.hzz.points.types.constants.RedisConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundZSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 使用redis来实现
 * boards::202408 001  100
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
@Repository
@Slf4j
public class PointsBoardCurrentRepositoryImpl implements PointsBoardCurrentRepository {

    @Setter(onMethod_ = @Autowired)
    private StringRedisTemplate redisTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public PointsBoardEntity queryUserCurrentPointsBoard(Long userId) {
        BoundZSetOperations<String, String> ops = redisTemplate.boundZSetOps(buildKey(LocalDateTime.now()));
        // zscore board::202408 userId
        Double score = ops.score(userId);

        // zrevrank board::202408 userId
        Long rank = ops.reverseRank(userId);

        PointsBoardEntity entity = new PointsBoardEntity();
        entity.setPoints(score == null ? 0 : score.intValue());
        // redis中的rank是以0开始的
        entity.setRank(rank == null ? 0 : (byte) (rank.intValue() + 1));
        return entity;
    }

    @Override
    public List<PointsBoardEntity> queryCurrentPointsBoardList(PageQuery pageQuery) {

        long start = pageQuery.getPageNo() - 1;
        long end = start + pageQuery.getPageSize() - 1;

        if(end >= 100){
            throw new BadRequestException("只支持查询100名以内的排名");
        }

        Set<ZSetOperations.TypedTuple<String>> pointsBoardTuples = redisTemplate.opsForZSet()
                .reverseRangeWithScores(
                        buildKey(LocalDateTime.now()),
                        start,
                        end
                );

        log.info("查询到{}条数据",pointsBoardTuples.size());

        List<PointsBoardEntity> result = new ArrayList<>();
        byte rank = (byte)(start + 1);
        for(ZSetOperations.TypedTuple<String> tuple: pointsBoardTuples){
            PointsBoardEntity entity = new PointsBoardEntity();
            entity.setUserId(Long.parseLong(tuple.getValue()));
            entity.setPoints(tuple.getScore().intValue());
            entity.setRank(rank++);
            result.add(entity);
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void incrUserPoints(PointsRecordEntity entity) {
        String key = buildKey(entity.getCreateTime());

        log.info("添加redis 积分排行榜 key = {} value = {} 添加积分 points = {}",
                key, entity.getUserId(), entity.getPoints());

        redisTemplate.opsForZSet()
                .incrementScore(
                        key,
                        entity.getUserId().toString(),
                        entity.getPoints());
    }

    /**
     * 构建key
     */
    private String buildKey(LocalDateTime dateTime) {
        String key = StrUtil.format(RedisConstants.BOARDS_TEMPLATE,
                dateTime.format(DateUtil.getMonthFormatCompact()));
        log.info("当前key = {}", key);
        return key;
    }
}
