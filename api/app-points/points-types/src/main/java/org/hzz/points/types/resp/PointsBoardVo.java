package org.hzz.points.types.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Data
public class PointsBoardVo {
    @Schema(description = "用户的积分排行榜")
    private Byte rank;
    @Schema(description = "用户的积分")
    private Integer points;
    @Schema(description = "排行榜")
    List<PointsBoardItemVo> boardList = Collections.emptyList();
}
