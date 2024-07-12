package org.hzz.user.domain.service.details.impl;

import org.hzz.core.service.BaseDomainService;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.repository.UserDetailRepository;
import org.hzz.user.domain.service.details.UserDetailDomainService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

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
    public List<UserDetailEntity> getEntities(Set<Long> ids) {
        List<UserDetailEntity> entities = repository.selectBatchByIds(ids);
        logger.info("查询到{}个用户详情",entities.size());
        return entities;
    }
}
