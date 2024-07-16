package org.hzz.user.domain.service.details.impl;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.service.BaseDomainService;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.repository.UserDetailRepository;
import org.hzz.user.domain.service.details.UserDetailDomainService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Service
public class UserDetailDomainServiceImpl
        extends BaseDomainService<UserDetailRepository>
        implements UserDetailDomainService
{

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetailEntity getEntityById(Long id) {
        UserDetailEntity userDetailEntity = repository.selectById(id);
        if(userDetailEntity != null){
            logger.info("查询出用户 {}",userDetailEntity.getName());
            return userDetailEntity;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UserDetailEntity> getEntities(Set<Long> ids) {
        List<UserDetailEntity> entities = repository.selectBatchByIds(ids);
        logger.info("查询到{}个用户详情",entities.size());
        if(CollUtil.isEmpty(entities)){
            return Collections.emptyList();
        }
        return entities;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<Long, UserDetailEntity> getMapEntities(Set<Long> ids) {

        List<UserDetailEntity> entities = this.getEntities(ids);
        if(CollUtil.isEmpty(entities)){
            return Collections.emptyMap();
        }
        return entities.stream().collect(Collectors.toMap(
                UserDetailEntity::getId,
                e -> e
        ));
    }
}
