package org.hzz.learning.application.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Data
@Builder
@Schema(description = "课程信息")
public class CourseDto {
    @Schema(description = "课程id")
    private Long id;
    @Schema(description = "课程名称")
    private String name;
    @Schema(description = "封面信息")
    private String coverUrl;
    @Schema(description = "小节数量")
    private Integer sections;
}
