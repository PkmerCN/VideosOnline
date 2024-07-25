package org.hzz.remark.infrastructure.repository.mybatis;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.converter.RecordAndEntityConverter;
import org.hzz.core.repository.nomapper.BaseRepository;
import org.hzz.remark.domain.entity.LikedRecordEntity;
import org.hzz.remark.domain.repository.LikedRecordRepository;
import org.hzz.remark.infrastructure.dao.mapper.liked.LikedRecordDynamicMapper;
import org.hzz.remark.infrastructure.dao.mapper.liked.LikedRecordMapper;
import org.hzz.remark.infrastructure.dao.model.liked.LikedRecord;
import org.hzz.remark.infrastructure.dao.model.liked.LikedRecordExample;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hzz.remark.infrastructure.dao.mapper.liked.LikedRecordDynamicSqlSupport.bizId;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Repository
public class LikedRecordRepositoryImpl
        extends BaseRepository<LikedRecordMapper>
        implements LikedRecordRepository {

    @Setter(onMethod_ = @Autowired)
    private LikedRecordDynamicMapper dynamicMapper;

    /**
     * 统计数量，
     * 这里使用dynamic sql来做
     * todo 运行时查看sql
     *
     * @param _bizId 业务id
     * @return 统计数量
     */
    @Override
    public long count(Long _bizId) {
        return dynamicMapper.count(c -> c.where(bizId, isEqualTo(_bizId)));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int insert(LikedRecordEntity entity) {
        LikedRecord record = Converter.INSTANCE.toRecord(entity);
        return mapper.insertSelective(record);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public int delete(Long id) {
        return mapper.deleteByPrimaryKey(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<LikedRecordEntity> selectOne(Long userId, Long bizId) {
        LikedRecordExample example = new LikedRecordExample();
        example.createCriteria()
                .andUserIdEqualTo(userId)
                .andBizIdEqualTo(bizId);
        List<LikedRecord> likedRecords = mapper.selectByExample(example);
        if (CollUtil.isEmpty(likedRecords)) {
            return Optional.<LikedRecordEntity>empty();
        } else {
            LikedRecordEntity entity = Converter.INSTANCE.toEntity(likedRecords.get(0));
            return Optional.of(entity);
        }
    }

    @Mapper
    interface Converter extends RecordAndEntityConverter<LikedRecord, LikedRecordEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
