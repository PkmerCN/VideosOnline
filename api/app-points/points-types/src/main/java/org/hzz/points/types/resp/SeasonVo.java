package org.hzz.points.types.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

/**
 * 赛季数据
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Data
@Schema(description = "赛季数据")
public class SeasonVo {
    @Schema(description = "id，season标示")
    private Integer id;

    @Schema(description = "赛季名称",example = "第1赛季")
    private String name;

    @Schema(description = "赛季开始时间")
    private LocalDate beginTime;
    
    @Schema(description = "赛季结束时间")
    private LocalDate endTime;
}
