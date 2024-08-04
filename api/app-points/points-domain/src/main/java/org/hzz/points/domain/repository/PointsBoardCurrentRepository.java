package org.hzz.points.domain.repository;

import org.hzz.core.page.query.PageQuery;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.entity.PointsRecordEntity;

import java.util.List;

/**
 * 积分排行榜redis repository
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
     * 查询当前积分排行榜
     */
    List<PointsBoardEntity> queryCurrentPointsBoardList(PageQuery pageQuery);

    /**
     * 查询上赛季积分排行榜
     */
    List<PointsBoardEntity> queryPrePointsBoardList(PageQuery pageQuery);


    /**
     * 增加用户当前赛季积分
     */
    void incrUserPoints(PointsRecordEntity entity);
}
