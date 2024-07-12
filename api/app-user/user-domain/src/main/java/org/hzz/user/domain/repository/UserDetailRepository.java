package org.hzz.user.domain.repository;

import org.hzz.user.domain.entity.UserDetailEntity;

import java.util.List;
import java.util.Set;

/**
 * 用户详情repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
public interface UserDetailRepository {

    /**
     * 根据id查询用户详情
     * @param ids 用户详情ids
     */
    List<UserDetailEntity> selectBatchByIds(Set<Long> ids);
}
