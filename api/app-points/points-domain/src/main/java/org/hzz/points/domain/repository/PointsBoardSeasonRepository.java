package org.hzz.points.domain.repository;

import org.hzz.points.domain.entity.PointsBoardSeasonEntity;

import java.util.List;
import java.util.Optional;

/**
 * 赛季
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
public interface PointsBoardSeasonRepository {

    /**
     * 查询全部赛季数据
     * @return list
     */
    List<PointsBoardSeasonEntity> selectAll();

    int insertSelective(PointsBoardSeasonEntity entity);


    /**
     * 获取目前最新的赛季
     */
    Optional<PointsBoardSeasonEntity> selectLatestOne();

    /**
     * 获取上个赛季
     */
    Optional<PointsBoardSeasonEntity> getPreSeason();
}
