package org.hzz.learning.types.req.question;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hzz.core.page.query.PageQuery;
import org.hzz.fastjson2.enums.BaseEnumReader;
import org.hzz.learning.types.enums.question.QuestionStatus;

import java.time.LocalDateTime;

/**
 * admin端的分页查询
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "admin端的分页查询")
public class AdminQuestionPageQuery extends PageQuery {
    @Schema(description = "课程名称")
    String courseName;

    @Schema(description = "问题查看状态 0（未查看）1已查看")
    @JSONField(deserializeUsing = BaseEnumReader.class)
    QuestionStatus status;
    @Schema(description = "提问最小时间")
    LocalDateTime beginTime;
    @Schema(description = "提问最大时间")
    LocalDateTime endTime;
}
