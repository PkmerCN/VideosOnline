package org.hzz.points.domain.repository;

import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.types.enums.PointsType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
public interface PointsRecordRepository {

    int insert(PointsRecordEntity entity);

    /**
     * 查询用户在指定时间 <code>localDateTime</code>当天的各种类型积分获得情况
     * @param _userId 用户id
     * @param localDateTime 时间
     * @return 统计数据
     */
    List<PointsRecordEntity> selectUserPointsByLocalDateTime(Long _userId, LocalDateTime localDateTime);


    /**
     * 获取用户当天指定类型<code>类型</code>的积分值，
     * @param _userId 用户id
     * @param localDateTime 时间
     * @param pointsType 积分类型
     * @return 积分值
     */
    Integer selectUserPointsByLocalDateTimeAndType(Long _userId, LocalDateTime localDateTime, PointsType pointsType);
}
