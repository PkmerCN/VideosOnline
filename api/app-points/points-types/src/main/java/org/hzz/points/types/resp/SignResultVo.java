package org.hzz.points.types.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 签到结果
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */

@Data
@Schema(description = "签到结果")
public class SignResultVo {

    @Schema(description = "连续签到的天数")
    private Integer signDays =  1;

    @Schema(description = "签到得到的积分")
    private Integer signPoints = 1;

    @Schema(description = "连续签到积分，连续签到7天以上才有奖励")
    private Integer rewardPoints;
    
}
