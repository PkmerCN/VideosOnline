package org.hzz.learning.api.req;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hzz.fastjson2.enums.BaseEnumReader;
import org.hzz.learning.domain.enums.SectionType;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
public class LearningRecordFormRequest {
    @Schema(description = "课程ID")
    @NotNull
    private Long lessonId;

    @Schema(description = "小节ID")
    @NotNull
    private Long sectionId;

    @Schema(description = "课程类型",example = "0或者1")
    @NotNull
    @JSONField(deserializeUsing = BaseEnumReader.class)
    private SectionType sectionType;

    @Schema(description = "提交时间")
    @NotNull
    private LocalDateTime commitTime;
    @Schema(description = "视频时长（秒）")
    @NotNull
    private Integer duration;
    @Schema(description = "视频播放进度（秒）")
    @NotNull
    private Integer moment;
}
