package org.hzz.learning.types.req.question;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hzz.core.page.query.PageQuery;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Schema(description = "问题分页查询")
public class QuestionPageQuery extends PageQuery {
    @Schema(description = "是否只查看自己的问题",example = "后台默认为false")
    Boolean onlyMine = false;
    @Schema(description = "课程id")
    Long courseId;
    @Schema(description = "小节id")
    Long sectionId;
}
