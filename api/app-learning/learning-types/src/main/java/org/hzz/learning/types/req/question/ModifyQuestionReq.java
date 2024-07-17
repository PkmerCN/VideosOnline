package org.hzz.learning.types.req.question;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
@Schema(description = "修改问题请求")
public class ModifyQuestionReq {
    @Schema(description = "互动问题的标题",example = "Java顶级开发")
    @NotBlank
    String title;

    @Schema(description = "问题描述信息",example = "打铁没样，边打边像")
    @NotBlank
    String description;

    @Schema(description = "是否匿名，默认false",example = "false")
    Boolean anonymity;
}
