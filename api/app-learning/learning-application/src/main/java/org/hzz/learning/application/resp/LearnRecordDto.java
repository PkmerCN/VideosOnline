package org.hzz.learning.application.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
@Schema(description = "小节学习记录")
public class LearnRecordDto {
    @Schema(description = "小节id")
    private Long sectionId;
    @Schema(description = "视频播放进度（秒）")
    private Integer moment;
    @Schema(description = "是否学完")
    private Boolean finished;
}
