package org.hzz.remark.domain.repository;

import org.hzz.remark.domain.entity.LikedRecordEntity;

import java.util.Optional;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
public interface LikedRecordRepository {

    /**
     * 添加一条记录
     * @param entity 点赞实体
     */
    int insert(LikedRecordEntity entity);

    /**
     * 点赞记录id
     * @param id 点赞记录id
     */
    int delete(Long id);

    /**
     * 获取点赞记录,userId和bizId做了唯一主键，所以用这个就可以了
     * @param userId 用户id
     * @param bizId 业务id
     * @return 点赞记录
     */
    Optional<LikedRecordEntity> selectOne(Long userId, Long bizId);
}
