package org.hzz.points.application.task;

import lombok.Setter;
import org.hzz.points.domain.service.points.PointsBoardDomainService;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardSeasonExtMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicSqlSupport.pointsBoard;

/**
 * 本赛季积分排行榜相关定时任务
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Component
public class PointsBoardPersistentTask {

    @Setter(onMethod_ = @Autowired)
    private PointsBoardDomainService domainService;

    @Setter(onMethod_ = @Autowired)
    private PointsBoardSeasonExtMapper boardSeasonExtMapper;
    private final String logicTableName = pointsBoard.tableNameAtRuntime();

    /**
     * 创建本赛季id
     */



    /**
     * 创建上赛季的一个积分排行表记录表
     */
    public void createPointsBoardTable(){
        LocalDateTime localDateTime = LocalDateTime.now().minusMonths(1);

        boardSeasonExtMapper.createPointsBoardSeasonTable(logicTableName + "_" + 1 );
    }
}
