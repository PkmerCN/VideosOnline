package org.hzz.learning.types.resp.question;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
@Schema(description = "问题")
public class QuestionDetailDto {
    @Schema(description = "主键，互动问题的id")
    private Long id;
    @Schema(description = "互动问题的标题")
    private String title;
    @Schema(description = "问题描述信息")
    private String description;
    @Schema(description = "问题下的回答数量")
    private Integer answerTimes;
    @Schema(description = "是否匿名，默认false")
    private Boolean anonymity;
    @Schema(description = "提问时间")
    private LocalDateTime createTime;

    @Schema(description = "提问者id")
    private Long userId;
    @Schema(description = "提问者用户名")
    private String username;
    @Schema(description = "提问者头像")
    private String userIcon;
}