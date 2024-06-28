package org.hzz.learning.application.service.resp;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hzz.fastjson2.enums.BaseEnumWriter;
import org.hzz.learning.domain.enums.LessonStatus;
import org.hzz.learning.domain.enums.PlanStatus;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
@Data
@Builder
@Schema(description = "学习课程信息")
public class LearnLessonDto {
    @Schema(description = "学习课程id")
    private Long id;

    @Schema(description = "学习计划状态，0-没有计划，1-计划进行中")
    @JSONField(serializeUsing = BaseEnumWriter.class)
    private PlanStatus planStatus;

    @Schema(description = "课程状态，0-未学习，1-学习中，2-已学完，3-已失效")
    @JSONField(serializeUsing = BaseEnumWriter.class)
    private LessonStatus lessonStatus;

    @Schema(description = "总已学习章节数")
    private Integer learnedSections;
    @Schema(description = "课程购买时间")
    private LocalDateTime createTime;
    @Schema(description = "课程过期时间")
    private LocalDateTime expireTime;
    @Schema(description = "课程信息")
    CourseDto course;
}
