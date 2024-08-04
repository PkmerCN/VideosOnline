package org.hzz.points.domain.repository;

import org.hzz.points.domain.entity.PointsBoardEntity;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
public interface PointsBoardHistoryRepository {

    /**
     * 批量插入
     * @param entities 要插入的数据
     * @return 插入的数量
     */
    int batchInsertSelective(List<PointsBoardEntity> entities);
}
