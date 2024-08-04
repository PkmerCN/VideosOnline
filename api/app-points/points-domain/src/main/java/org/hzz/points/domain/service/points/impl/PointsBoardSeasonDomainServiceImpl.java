package org.hzz.points.domain.service.points.impl;

import cn.hutool.core.util.StrUtil;
import org.hzz.common.date.DateUtil;
import org.hzz.core.service.BaseDomainService;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;
import org.hzz.points.domain.repository.PointsBoardSeasonRepository;
import org.hzz.points.domain.service.points.PointsBoardSeasonDomainService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Service
public class PointsBoardSeasonDomainServiceImpl
        extends BaseDomainService<PointsBoardSeasonRepository>
        implements PointsBoardSeasonDomainService {

    final String seasonTemplate = "第{}赛季";

    /**
     * {@inheritDoc}
     * @return List赛季数据
     */
    @Override
    public List<PointsBoardSeasonEntity> getAllSeason() {
        List<PointsBoardSeasonEntity> seasons = repository.selectAll();
        logger.info("从数据库查询到赛季数据{}条",seasons.size());
        return seasons;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void genCurrentSeason() {
        Optional<PointsBoardSeasonEntity> entityOptional = repository.selectLatestOne();
        if(entityOptional.isPresent()){
            logger.info("处理下一个赛季");
            PointsBoardSeasonEntity entity = entityOptional.get();
            // 赛季id
            Integer id = entity.getId();
            String seasonName = entity.getName();
            String currentSeasonName = genSeasonName(id + 1);
            logger.info("上个赛季: {} >>> 新赛季: {}",seasonName,currentSeasonName);
            // 处理下一个赛季
            genNewSeason(currentSeasonName);
        }else{
            logger.info("生成第一个赛季");
            initFirstSeason();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<PointsBoardSeasonEntity> getPreSeason() {
        return repository.getPreSeason();
    }

    /**
     * 初始化第一个赛季
     */
    private void initFirstSeason(){
        final Integer firstSeasonId = 1;
        String name = StrUtil.format(seasonTemplate, firstSeasonId);
        genNewSeason(name);
    }

    private void genNewSeason(String seasonName){
        PointsBoardSeasonEntity newSeason = new PointsBoardSeasonEntity();
        // 使用数据库的自增主键来处理
//        newSeason.setId(seasonId);
        newSeason.setName(seasonName);
        newSeason.setBeginTime(DateUtil.getCurrentStartOfDay());
        newSeason.setEndTime(DateUtil.getCurrentEndOfDay());

        repository.insertSelective(newSeason);
    }

    /**
     * 新赛季名称
     * @param index 第几个赛季
     */
    private String genSeasonName(Integer index){
        return StrUtil.format(seasonTemplate, index);
    }
}
