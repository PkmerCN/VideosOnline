package org.hzz.points.infrastructure.repository.mybatis;

import lombok.Setter;
import org.hzz.core.converter.RecordAndEntityConverter;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.repository.PointsBoardHistoryRepository;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicMapper;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardMapper;
import org.hzz.points.infrastructure.dao.model.points.PointsBoard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicSqlSupport.pointsBoard;
import static org.mybatis.dynamic.sql.SqlBuilder.insertMultiple;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Repository
public class PointsBoardHistoryRepositoryImpl implements PointsBoardHistoryRepository {

    @Setter(onMethod_ = @Autowired)
    private PointsBoardDynamicMapper dynamicMapper;

    @Setter(onMethod_ = @Autowired)
    private PointsBoardMapper mapper;

    @Override
    public int batchInsertSelective(List<PointsBoardEntity> entities) {
        // todo 整理笔记 真实处理
        List<PointsBoard> records = Converter.INSTANCE.toRecords(entities);
        MultiRowInsertStatementProvider<PointsBoard> into = insertMultiple(records)
                .into(pointsBoard)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return dynamicMapper.insertMultiple(into);
    }

    @Mapper
    interface Converter extends RecordAndEntityConverter<PointsBoard,PointsBoardEntity>{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
