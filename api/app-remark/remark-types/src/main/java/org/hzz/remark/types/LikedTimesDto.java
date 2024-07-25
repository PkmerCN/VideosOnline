package org.hzz.remark.types;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Data
@Accessors(chain = true)
public class LikedTimesDto {
    Long bizId;
    Long likeTimes;
}
