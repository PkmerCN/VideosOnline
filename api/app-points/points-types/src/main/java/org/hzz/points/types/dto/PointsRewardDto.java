package org.hzz.points.types.dto;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

/**
 * 积分奖励载体
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Data
@Accessors(chain = true)
@Value(staticConstructor = "of")
public class PointsRewardDto {
    Long userId;
    Integer points;
}
