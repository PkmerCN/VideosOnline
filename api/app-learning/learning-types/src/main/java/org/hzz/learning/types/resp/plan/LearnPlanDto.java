package org.hzz.learning.types.resp.plan;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Data
@Accessors(chain = true,fluent = true)
public class LearnPlanDto {
    @Schema(description = "课程ID")
    private Long courseId;
    @Schema(description = "课程名字")
    private String courseName;
    @Schema(description = "本周已学习的小节数量")
    private Integer weekLearnedSections;
    @Schema(description = "本周计划学习")
    private Integer weekFreq;
    @Schema(description = "总已学习小节数量")
    private Integer learnedSections;
    @Schema(description = "课程总小节数量")
    private Integer sections;
    @Schema(description = "最近学习时间")
    private LocalDateTime latestLearnTime;
}
