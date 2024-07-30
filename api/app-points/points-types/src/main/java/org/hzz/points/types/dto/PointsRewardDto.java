package org.hzz.points.types.dto;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;
import org.hzz.fastjson2.enums.BaseEnumWriter;
import org.hzz.points.types.enums.PointsType;

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

    @JSONField(serializeUsing = BaseEnumWriter.class)
    PointsType type;
}
