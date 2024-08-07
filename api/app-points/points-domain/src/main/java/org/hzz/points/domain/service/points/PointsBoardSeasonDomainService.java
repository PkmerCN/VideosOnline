package org.hzz.points.domain.service.points;

import org.hzz.ddd.core.domain.shared.service.DomainService;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;

import java.util.List;
import java.util.Optional;

/**
 * 赛季领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
public interface PointsBoardSeasonDomainService extends DomainService {

    /**
     * 获取全部赛季数据
     * @return List赛季数据
     */
    List<PointsBoardSeasonEntity> getAllSeason();

    /**
     * 生成当前赛季
     */
    void genCurrentSeason();

    /**
     * 获取上个赛季
     */
    Optional<PointsBoardSeasonEntity> getPreSeason();


}
