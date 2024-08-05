package org.hzz.points.domain.repository;

import org.hzz.core.page.query.PageQuery;
import org.hzz.points.domain.entity.PointsBoardEntity;

import java.util.List;
import java.util.Optional;

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


    /**
     * 查询历史积分排行榜
     * @param pageQuery 分页
     * @return 历史赛季积分排行榜
     */
    List<PointsBoardEntity> queryHistoryPointsBoardList(PageQuery pageQuery);

    /**
     * 查询用户历史赛季积分排行榜
     * @param userId 用户id
     * @return 用户排行榜
     */
    Optional<PointsBoardEntity> queryUserHistoryPointsBoard(Long userId);
}
