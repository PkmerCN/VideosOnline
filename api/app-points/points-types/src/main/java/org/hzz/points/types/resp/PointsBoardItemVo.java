package org.hzz.points.types.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Data
public class PointsBoardItemVo {
    @Schema(description = "用户的积分排行榜")
    private Byte rank;
    @Schema(description = "用户的积分")
    private Integer points;
    @Schema(description = "用户名称")
    private String userName;
}
