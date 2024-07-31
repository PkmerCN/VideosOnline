package org.hzz.points.domain.service.points.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;
import org.hzz.points.domain.repository.PointsBoardSeasonRepository;
import org.hzz.points.domain.service.points.PointsBoardSeasonDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Service
public class PointsBoardSeasonDomainServiceImpl
        extends BaseDomainService<PointsBoardSeasonRepository>
        implements PointsBoardSeasonDomainService {

    /**
     * {@inheritDoc}
     * @return List赛季数据
     */
    @Override
    public List<PointsBoardSeasonEntity> getAllSeason() {
        List<PointsBoardSeasonEntity> seasons = repository.selectAll();
        logger.info("查询到赛季数据{}条",seasons.size());
        return seasons;
    }
}
