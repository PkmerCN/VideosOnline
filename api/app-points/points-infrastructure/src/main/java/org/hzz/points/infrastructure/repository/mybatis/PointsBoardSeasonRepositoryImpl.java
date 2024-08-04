package org.hzz.points.infrastructure.repository.mybatis;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.core.converter.RecordAndEntityConverter;
import org.hzz.points.domain.entity.PointsBoardSeasonEntity;
import org.hzz.points.domain.repository.PointsBoardSeasonRepository;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardSeasonDynamicMapper;
import org.hzz.points.infrastructure.dao.mapper.points.PointsBoardSeasonMapper;
import org.hzz.points.infrastructure.dao.model.points.PointsBoardSeason;
import org.hzz.points.infrastructure.dao.model.points.PointsBoardSeasonExample;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hzz.points.infrastructure.dao.mapper.points.PointsBoardSeasonDynamicSqlSupport.beginTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Repository
@Slf4j
public class PointsBoardSeasonRepositoryImpl implements PointsBoardSeasonRepository {

    @Setter(onMethod_ = @Autowired)
    private PointsBoardSeasonMapper mapper;
    @Setter(onMethod_ = @Autowired)
    private PointsBoardSeasonDynamicMapper dynamicMapper;

    /**
     * {@inheritDoc}
     * @return 全部赛季数据
     */
    @Override
    public List<PointsBoardSeasonEntity> selectAll() {
        /**
         * 比较一下传统方式example与dynamic sql的写法却别
         */
//        List<PointsBoardSeason> records1 = mapper.selectByExample(null);
//        List<PointsBoardSeason> records2 = dynamicMapper.select(SelectDSLCompleter.allRows());
//
//        PointsBoardSeasonExample example = new PointsBoardSeasonExample();
//        example.setOrderByClause(beginTime.orderByName() +" "+"desc");
//        List<PointsBoardSeason> records3 = mapper.selectByExample(example);

        List<PointsBoardSeason> records4 = dynamicMapper.select(SelectDSLCompleter.allRowsOrderedBy(beginTime.descending()));
        // 默认order by 一个字段，默认的排序方式就是asc
//        List<PointsBoardSeason> records5 = dynamicMapper.select(SelectDSLCompleter.allRowsOrderedBy(beginTime));

        return Converter.INSTANCE.toEntities(records4);
    }

    @Override
    public int insertSelective(PointsBoardSeasonEntity entity) {
        PointsBoardSeason record = Converter.INSTANCE.toRecord(entity);
        int i = mapper.insertSelective(record);
        // 设置生成的id
        entity.setId(record.getId());
        return i;
    }

    @Override
    public Optional<PointsBoardSeasonEntity> selectLatestOne() {
        Optional<PointsBoardSeason> recordOptional = dynamicMapper.selectOne(c -> c.orderBy(beginTime.descending()));
        if(recordOptional.isPresent()){
            PointsBoardSeason record = recordOptional.get();
            PointsBoardSeasonEntity entity = Converter.INSTANCE.toEntity(record);
            return Optional.of(entity);
        }
        return Optional.empty();
    }

    @Mapper
    interface Converter extends RecordAndEntityConverter<PointsBoardSeason,PointsBoardSeasonEntity>{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
