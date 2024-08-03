package org.hzz.points.domain.service.points.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.domain.repository.PointsRecordRepository;
import org.hzz.points.domain.service.points.PointsDomainService;
import org.hzz.points.types.enums.PointsType;
import org.hzz.points.types.resp.PointsStatisticsVo;
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


    @Override
    public void addPoints(PointsRecordEntity entity) {
        // todo 判断此时用户获得积分上限

        List<PointsRecordEntity> pointsRecordEntities = repository.selectUserPointsByLocalDateTime(entity.getUserId(), LocalDateTime.now());



        int i = repository.insert(entity);
        logger.info("插入积分记录{}条",i);
    }

    /**
     * {@inheritDoc}
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

        for(PointsType type: types){
            PointsStatisticsVo vo = new PointsStatisticsVo();
            vo.setPoints(map.getOrDefault(type,(byte)0).intValue());
            vo.setType(type.getDesc());
            vo.setMaxPoints(type.getMaxPoints());
            result.add(vo);
        }

        return result;
    }
}
