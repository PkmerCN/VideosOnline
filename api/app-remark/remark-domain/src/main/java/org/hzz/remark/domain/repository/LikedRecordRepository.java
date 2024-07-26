package org.hzz.remark.domain.repository;

import org.hzz.remark.domain.entity.LikedRecordEntity;

import java.util.Optional;
import java.util.Set;

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
     * 统计数量
     * @param _bizId 业务id
     * @return 数量
     */

    long count(Long _bizId);

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

    /**
     * 查询校验用户点赞的业务
     * @param _userId 用户id
     * @param _bizIds 业务id集合
     * @return 用户已经在bizIds中点赞过的业务id集合
     */
    Set<Long> checkUserLikeBizId(Long _userId,Set<Long> _bizIds);
}
