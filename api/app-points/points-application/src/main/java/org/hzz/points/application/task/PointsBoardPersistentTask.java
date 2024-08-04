package org.hzz.points.application.task;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;
import org.hzz.points.domain.service.points.PointsBoardDomainService;
import org.hzz.points.domain.service.points.PointsBoardSeasonDomainService;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardSeasonExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicSqlSupport.pointsBoard;

/**
 * 本赛季积分排行榜相关定时任务
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Component
@Slf4j
public class PointsBoardPersistentTask {

    @Setter(onMethod_ = @Autowired)
    private PointsBoardSeasonDomainService boardSeasonDomainService;

    @Setter(onMethod_ = @Autowired)
    private PointsBoardDomainService pointsBoardDomainService;

    @Setter(onMethod_ = @Autowired)
    private PointsBoardSeasonExtMapper boardSeasonExtMapper;
    private final String logicTableName = pointsBoard.tableNameAtRuntime();


    /**
     * 每一个月初生成新赛季，只生成赛季id，并没有创建表
     * 创建本赛季id
     */
    // todo xxljob
    public void genNewSeason(){
        boardSeasonDomainService.genCurrentSeason();
    }



    /**
     * 每个月初创建上赛季的一个积分排行表记录表
     */
    public void createPointsBoardTable(){

        Optional<PointsBoardSeasonEntity> preSeasonOptional = boardSeasonDomainService.getPreSeason();
        if(preSeasonOptional.isEmpty()){
            log.info("没有上个赛季");
            return;
        }

        PointsBoardSeasonEntity preSeason = preSeasonOptional.get();
        log.info("准备生成{}的相关表",preSeason.getName());
        boardSeasonExtMapper.createPointsBoardSeasonTable(logicTableName + "_" + preSeason.getId() );
    }


    public void persistentPointsBoard(){



    }
}
