package org.hzz.points.domain.service.points.impl;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import org.hzz.common.date.DateUtil;
import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.domain.repository.PointsRecordRepository;
import org.hzz.points.domain.service.points.PointsDomainService;
import org.hzz.points.types.constants.RedisConstants;
import org.hzz.points.types.enums.PointsType;
import org.hzz.points.types.resp.PointsStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Service
public class PointsDomainServiceImpl
        extends BaseDomainService<PointsRecordRepository>
        implements PointsDomainService {

    @Setter(onMethod_ = @Autowired)
    private StringRedisTemplate redisTemplate;

    @Override
    public void addPoints(PointsRecordEntity entity) {
        // 当前添加的积分类型
        PointsType pointsType = entity.getType();

        // 获取用户当日指定类型的积分值
        Integer currentPoints = getUserCurrentPoints(entity);
        // 处理此时用户获得积分上限
        if (currentPoints >= pointsType.getMaxPoints()) {
            logger.info("用户(id = {}) 在{}时间，获取{}类型的积分已经达到上限：用户获取的已经获取的积分值{},上限积分{}",
                    entity.getUserId(), entity.getCreateTime(), pointsType.getDesc(), currentPoints, pointsType.getMaxPoints());
            return;
        }

        /**
         *  防止这种情况发生 上限积分50，已获得积分是45，现在要添加积分+10.
         *  如果直接插入数据库总积分会变成55.
         *  所以计算一下
         */
        if ((entity.getPoints() + currentPoints) > pointsType.getMaxPoints()) {
            logger.info("计算实际获得积分，防止超过上限");
            int realPoints = pointsType.getMaxPoints() - currentPoints;
            entity.setPoints((byte) realPoints);
        }

        // 保存积分记录
        savePointsRecord(entity);

        // 累加积分到redis,计算总量
        incrPointsToRedisPointsBoards(entity);
    }

    /**
     * 获取用户当日指定类型的积分值
     */
    private Integer getUserCurrentPoints(PointsRecordEntity entity) {
        return repository.selectUserPointsByLocalDateTimeAndType(
                entity.getUserId(),
                entity.getCreateTime(),
                entity.getType());
    }

    /**
     * 保存积分记录
     */
    private void savePointsRecord(PointsRecordEntity entity) {
        int i = repository.insert(entity);
        logger.info("插入积分记录{}条", i);
    }

    /**
     * 累加积分到redis
     */
    private void incrPointsToRedisPointsBoards(PointsRecordEntity entity) {
        String key = StrUtil.format(RedisConstants.BOARDS_TEMPLATE,
                entity.getCreateTime().format(DateUtil.getMonthFormatCompact()));

        logger.info("添加redis 积分排行榜 key = {} value = {} 添加积分 points = {}",
                key, entity.getUserId(), entity.getPoints());

        redisTemplate.opsForZSet()
                .incrementScore(
                        key,
                        entity.getUserId().toString(),
                        entity.getPoints());
    }


    /**
     * {@inheritDoc}
     *
     * @param userId 用户id
     * @return
     */
    @Override
    public List<PointsStatisticsVo> queryUserPointsForToday(Long userId) {
        List<PointsRecordEntity> pointsRecordEntities = repository.selectUserPointsByLocalDateTime(userId, LocalDateTime.now());
        // todo 测试map能否获取到正确的value
        Map<PointsType, Byte> map = pointsRecordEntities.stream().collect(Collectors.toMap(
                PointsRecordEntity::getType,
                PointsRecordEntity::getPoints
        ));

        PointsType[] types = PointsType.values();
        List<PointsStatisticsVo> result = new ArrayList<>(types.length);

        for (PointsType type : types) {
            PointsStatisticsVo vo = new PointsStatisticsVo();
            vo.setPoints(map.getOrDefault(type, (byte) 0).intValue());
            vo.setType(type.getDesc());
            vo.setMaxPoints(type.getMaxPoints());
            result.add(vo);
        }

        return result;
    }
}
