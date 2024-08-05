package org.hzz.points.application.task;

import com.xxl.job.core.context.XxlJobHelper;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.page.query.PageQuery;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;
import org.hzz.points.domain.service.points.PointsBoardDomainService;
import org.hzz.points.domain.service.points.PointsBoardSeasonDomainService;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardSeasonExtMapper;
import org.hzz.points.infrastructure.dao.plugin.ChangePointsBoardTableNamePlugin;
import org.hzz.points.infrastructure.dao.plugin.support.PointsBoardTableIndexSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
     * 顺序1
     * 每一个月初生成新赛季，只生成赛季id，并没有创建表
     * 创建本赛季id
     */
    // todo xxljob
    public void genNewSeason(){
        log.info("xxljob 生成新赛季");
        boardSeasonDomainService.genCurrentSeason();
    }



    /**
     * 顺序2
     * 每个月初创建上赛季的一个积分排行表记录表
     * 必须确保新的赛季已经生成，{@link PointsBoardPersistentTask#genNewSeason()}
     */
    public void createPointsBoardTable(){
        PointsBoardSeasonEntity season = getPersistentSeason();
        log.info("xxljob 准备生成{}的相关表",season.getName());
        boardSeasonExtMapper.createPointsBoardSeasonTable(logicTableName + "_" + season.getId() );
    }


    /**
     * 顺序3
     * 持久化积分排行榜
     */
    public void persistentPointsBoard(){
        log.info("xxljob 持久化积分排行榜");
        PointsBoardSeasonEntity season = getPersistentSeason();
        int count = 0;

        // xxljob 分片处理,防止重复插入
//        int shardIndex = XxlJobHelper.getShardIndex();
//        int shardTotal = XxlJobHelper.getShardTotal();

        int pageSize = 10;
        int pageNo = 1;

        try{
            /**
             * 分表的处理
             * {@link ChangePointsBoardTableNamePlugin}
             */
            PointsBoardTableIndexSupport.setTableIndex(season.getId());

            while(true){
                PageQuery pageQuery = new PageQuery();
                pageQuery.setPageSize(pageSize);
                pageQuery.setPageNo(pageNo);
                // 从redis查询上赛季的积分数据
                List<PointsBoardEntity> pointsBoardEntities = pointsBoardDomainService.queryPrePointsBoardList(pageQuery);

                if (pointsBoardEntities.isEmpty()){
                    break;
                }
                // 设置赛季id
                pointsBoardEntities.forEach(e -> e.setSeason(season.getId().shortValue()));
                // 持久化到mysql
                int i = pointsBoardDomainService.addPointsBoard(pointsBoardEntities);
                count += i;

                // 翻页 todo 使用xxljob total
                pageNo++;
            }
            log.info("成功持久化{}条记录",count);
        }finally {
            PointsBoardTableIndexSupport.clear();
        }
    }


    /**
     * 顺序4
     * 清楚redis中的积分排行榜
     */
    public void clearPointsBoardFromRedis(){
        log.info("xxljob 迁移成功准备清除上赛季数据");
        pointsBoardDomainService.clearPrePointsBoardList();
    }




    /**
     * 获取处理的赛季
     * @return 赛季
     */
    private PointsBoardSeasonEntity getPersistentSeason(){
        return boardSeasonDomainService
                .getPreSeason()
                .orElseThrow(() -> new RuntimeException("对应的赛季表还没有生成"));
    }


    /**
     * 直接按顺序排列好
     */
    public void persistent(){
        log.info("总流程");
//        genNewSeason();
//        createPointsBoardTable();
        persistentPointsBoard();
//        clearPointsBoardFromRedis();
    }
}
