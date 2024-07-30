package org.hzz.points.domain.service.points.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.domain.repository.PointsRecordRepository;
import org.hzz.points.domain.service.points.PointsDomainService;
import org.springframework.stereotype.Service;

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
        int i = repository.insert(entity);
        logger.info("插入积分记录{}条",i);
    }
}
