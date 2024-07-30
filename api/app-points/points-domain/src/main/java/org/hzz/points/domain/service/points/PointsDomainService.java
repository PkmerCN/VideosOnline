package org.hzz.points.domain.service.points;

import org.hzz.ddd.core.domain.shared.service.DomainService;
import org.hzz.points.domain.entity.PointsRecordEntity;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
public interface PointsDomainService extends DomainService {

    /**
     * 添加积分
     * @param entity 积分记录
     */
    void addPoints(PointsRecordEntity entity);
}
