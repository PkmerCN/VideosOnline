package org.hzz.points.infrastructure.repository.mybatis;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.date.DateUtil;
import org.hzz.core.converter.RecordAndEntityConverter;
import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.domain.repository.PointsRecordRepository;
import org.hzz.points.infrastructure.dao.mapper.points.PointsRecordDynamicMapper;
import org.hzz.points.infrastructure.dao.mapper.points.PointsRecordMapper;
import org.hzz.points.infrastructure.dao.model.points.PointsRecord;
import org.hzz.points.types.constants.PointsRecordFields;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Repository
@Slf4j
public class PointsRecordRepositoryImpl implements PointsRecordRepository {

    @Setter(onMethod_ = @Autowired)
    private PointsRecordMapper mapper;
    @Setter(onMethod_ = @Autowired)
    private PointsRecordDynamicMapper dynamicMapper;

    @Override
    public int insert(PointsRecordEntity entity) {
        PointsRecord record = Converter.INSTANCE.toRecord(entity);
        return mapper.insertSelective(record);
    }

    /**
     * {@inheritDoc}
     *
     * @param _userId       用户id
     * @param localDateTime 时间
     * @return 数据统计情况
     */
    @Override
    public List<PointsRecordEntity> selectUserPointsByLocalDateTime(Long _userId, LocalDateTime localDateTime) {
        /**
         * 这里我们使用的是mybatis dynamic sql
         * where condition
         * https://mybatis.org/mybatis-dynamic-sql/docs/conditions.html
         */

        SelectStatementProvider selectSql = select(type, sum(points).as(PointsRecordFields.POINTS))
                .from(pointsRecord)
                .where(userId, isEqualTo(_userId))
                .and(createTime, isBetween(DateUtil.getStartOfDay(localDateTime)).and(DateUtil.getEndOfDay(localDateTime)))
                .groupBy(type)
                .build().render(RenderingStrategies.MYBATIS3);

        log.info("执行SQL: {}",selectSql.getSelectStatement());

        List<PointsRecord> pointsRecords = dynamicMapper.selectMany(selectSql);
        return Converter.INSTANCE.toEntities(pointsRecords);
    }

    @Mapper
    interface Converter extends RecordAndEntityConverter<PointsRecord, PointsRecordEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
