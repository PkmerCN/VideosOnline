package org.hzz.points.types.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Data
@Schema(description = "用户今日获取积分统计")
public class PointsStatisticsVo {

    @Schema(description = "积分类型")
    private String type;

    @Schema(description = "今日获得积分")
    private Integer points;

    @Schema(description = "单日积分上限")
    private Integer maxPoints;

}
