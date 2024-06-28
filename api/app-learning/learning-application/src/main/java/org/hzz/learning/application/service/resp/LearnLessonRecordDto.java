package org.hzz.learning.application.service.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
@Schema(description = "用户学习课程记录")
public class LearnLessonRecordDto {
    @Schema(description = "用户学习的课程id")
    private Long id;
    @Schema(description = "最新学习的小节id")
    private Long latestSectionId;
    @Schema(description = "小节学习进度列表")
    List<LearnRecordDto> records;

}
