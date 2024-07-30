package org.hzz.points.infrastructure.repository.mybatis;

import lombok.Setter;
import org.hzz.core.converter.RecordAndEntityConverter;
import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.domain.repository.PointsRecordRepository;
import org.hzz.points.infrastructure.dao.mapper.points.PointsRecordDynamicMapper;
import org.hzz.points.infrastructure.dao.mapper.points.PointsRecordMapper;
import org.hzz.points.infrastructure.dao.model.points.PointsRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Repository
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

    @Mapper
    interface Converter extends RecordAndEntityConverter<PointsRecord,PointsRecordEntity>{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
