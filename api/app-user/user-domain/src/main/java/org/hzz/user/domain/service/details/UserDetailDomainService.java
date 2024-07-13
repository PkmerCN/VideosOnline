package org.hzz.user.domain.service.details;

import org.hzz.user.domain.entity.UserDetailEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户详情领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
public interface UserDetailDomainService {

    /**
     * 根据id获取用户详情
     * @param id 用户id
     * @return 用户详情
     */

    UserDetailEntity getEntityById(Long id);
    /**
     * 获取用户详情 列表
     * @param ids id列表
     * @return {@link UserDetailEntity} 列表
     */
    List<UserDetailEntity> getEntities(Set<Long> ids);

    /**
     * 获取用户详情 列表
     * @param ids id列表
     * @return Map key为id value为{@link UserDetailEntity}
     */
    Map<Long,UserDetailEntity> getMapEntites(Set<Long> ids);
}
