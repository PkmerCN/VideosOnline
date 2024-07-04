package org.hzz.learning.types.resp.plan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hzz.core.page.PageResponse;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class LearnPlansPageResult extends PageResponse<LearnPlanDto> {
    @Schema(description = "本周积分")
    private Integer weekPoints;
    @Schema(description = "本周完成小节数")
    private Integer weekFinished;
    @Schema(description = "本周总计划数")
    private Integer weekTotalPlan;
}
