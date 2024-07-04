package org.hzz.learning.api.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 添加课程计划请求
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Data
public class LearnPlanReq {

    @Schema(description = "课程Id",example = "2")
    @NotNull
    private Long couseId;
    @Schema(description = "每周学习频率，例如每周学习6小节，则频率为6",example = "6")
    @Range(min = 1,max = Byte.MAX_VALUE)
    private Integer freq;
}
