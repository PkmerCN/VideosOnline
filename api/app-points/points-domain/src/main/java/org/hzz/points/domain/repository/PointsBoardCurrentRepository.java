package org.hzz.points.domain.repository;

import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.entity.PointsRecordEntity;

/**
 * 积分排行榜repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
public interface PointsBoardCurrentRepository {
    /**
     * 查询用户当前积分排名
     */
    PointsBoardEntity queryUserCurrentPointsBoard(Long userId);

    /**
     * 增加用户当前赛季积分
     */
    void incrUserPoints(PointsRecordEntity entity);
}
