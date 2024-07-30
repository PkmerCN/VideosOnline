package org.hzz.points.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.Entity;
import org.hzz.points.types.enums.PointsType;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Data
@Accessors(chain = true)
public class PointsRecordEntity implements Entity {
    // 积分记录表id
    private Long id;

    // 用户id
    private Long userId;

    // 积分方式：1-课程学习，2-每日签到，3-课程问答， 4-课程笔记，5-课程评价
    private PointsType type;

    // 积分值
    private Byte points;

    // 创建时间
    private LocalDateTime createTime;
}
