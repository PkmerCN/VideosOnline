package org.hzz.learning.types.req.lesson;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hzz.fastjson2.enums.BaseEnumReader;
import org.hzz.learning.domain.enums.SectionType;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
@Schema(description = "提交记录")
public class LearningRecordFormRequest {
    public interface VideoGroup{}
    public interface ExamGroup{}

    @Schema(description = "课程ID",example = "7211836839752241153")
    @NotNull(groups = {VideoGroup.class,ExamGroup.class})
    private Long lessonId;

    @Schema(description = "小节ID")
    @NotNull(groups = {VideoGroup.class,ExamGroup.class})
    private Long sectionId;

    @Schema(description = "课程类型",example = "1或者2")
    @NotNull(groups = {VideoGroup.class,ExamGroup.class})
    @JSONField(deserializeUsing = BaseEnumReader.class)
    private SectionType sectionType;

    @Schema(description = "提交时间",example = "")
    @NotNull(groups = {VideoGroup.class,ExamGroup.class})
    private LocalDateTime commitTime;

    @Schema(description = "视频时长（秒）")
    @NotNull(groups = {VideoGroup.class})
    private Integer duration;

    @Schema(description = "视频播放进度（秒）")
    @NotNull(groups = {VideoGroup.class})
    private Integer moment;
}
