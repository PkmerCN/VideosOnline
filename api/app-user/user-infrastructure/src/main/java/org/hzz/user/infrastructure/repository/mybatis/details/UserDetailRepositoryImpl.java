package org.hzz.user.infrastructure.repository.mybatis.details;

import org.hzz.core.repository.nomapper.BaseRepository;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.repository.UserDetailRepository;
import org.hzz.user.infrastructure.dao.entity.details.UserDetail;
import org.hzz.user.infrastructure.dao.entity.details.UserDetailExample;
import org.hzz.user.infrastructure.dao.mapper.details.UserDetailMapper;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 用户详情repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Repository
public class UserDetailRepositoryImpl
        extends BaseRepository<UserDetailMapper>
        implements UserDetailRepository
{

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetailEntity selectById(Long id) {
        UserDetail userDetail = mapper.selectByPrimaryKey(id);
        return Converter.INSTANCE.toEntity(userDetail);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDetailEntity> selectBatchByIds(Set<Long> ids) {
        UserDetailExample example = new UserDetailExample();
        example.createCriteria().andIdIn(new ArrayList<>(ids));
        List<UserDetail> records = mapper.selectByExample(example);
        return Converter.INSTANCE.toEntities(records);
    }

    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
        List<UserDetailEntity> toEntities(List<UserDetail> records);
        UserDetailEntity toEntity(UserDetail record);
    }
}
