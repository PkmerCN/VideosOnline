package org.hzz.points.infrastructure.repository.mybatis;

import lombok.Setter;
import org.hzz.core.converter.RecordAndEntityConverter;
import org.hzz.core.page.query.PageQuery;
import org.hzz.points.domain.entity.PointsBoardEntity;
import org.hzz.points.domain.repository.PointsBoardHistoryRepository;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicMapper;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardMapper;
import org.hzz.points.infrastructure.dao.model.points.PointsBoard;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicSqlSupport.rank;
import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardDynamicSqlSupport.userId;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

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

    /**
     * {@inheritDoc}
     * @param entities 要插入的数据
     * @return
     */
    @Override
    public int batchInsertSelective(List<PointsBoardEntity> entities) {
        // todo 整理笔记 真实处理
        List<PointsBoard> records = Converter.INSTANCE.toRecords(entities);
//        MultiRowInsertStatementProvider<PointsBoard> into = insertMultiple(records)
//                .into(pointsBoard)
//                .map(id).toProperty("id")
//                .map(userId).toProperty("userId")
//                .map(points).toProperty("points")
//                .map(rank).toProperty("rank")
//                .map(season).toProperty("season")
//                .build()
//                .render(RenderingStrategies.MYBATIS3);
//        dynamicMapper.insertMultiple(into);

        return dynamicMapper.insertMultiple(records);
    }

    /**
     * {@inheritDoc}
     * @param pageQuery 分页
     * @return
     */
    @Override
    public List<PointsBoardEntity> queryHistoryPointsBoardList(PageQuery pageQuery) {

        int offset = (pageQuery.getPageNo() - 1) * pageQuery.getPageSize();
        int rowCount = pageQuery.getPageSize();

        List<PointsBoard> records = dynamicMapper.select(c -> c.
                orderBy(rank)
                .limit(rowCount)
                .offset(offset));

        return Converter.INSTANCE.toEntities(records);
    }

    /**
     * {@inheritDoc}
     * @param _userId 用户id
     * @return
     */
    @Override
    public Optional<PointsBoardEntity> queryUserHistoryPointsBoard(Long _userId) {

        Optional<PointsBoard> recordOptional = dynamicMapper.selectOne(c -> c.where(userId, isEqualTo(_userId)));

        if (recordOptional.isPresent()) {
            PointsBoard record = recordOptional.get();
            PointsBoardEntity entity = Converter.INSTANCE.toEntity(record);
            return Optional.of(entity);
        }

        return Optional.empty();
    }

    @Mapper
    interface Converter extends RecordAndEntityConverter<PointsBoard, PointsBoardEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
