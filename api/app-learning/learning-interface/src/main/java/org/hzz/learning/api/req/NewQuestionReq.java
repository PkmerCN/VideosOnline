package org.hzz.learning.api.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Data
@Schema(name = "新增问题")
public class NewQuestionReq {
    @Schema(description = "互动问题的标题",example = "Java顶级开发")
    @NotBlank
    String title;

    @Schema(description = "问题描述信息",example = "打铁没样，边打边像")
    @NotBlank
    String description;

    @Schema(description = "所属课程id",example = "2")
    @NotNull
    Long courseId;

    @Schema(description = "所属课程章id",example = "15")
    @NotNull
    Long chapterId;

    @Schema(description = "所属课程节id",example = "16")
    @NotNull
    Long sectionId;
}
