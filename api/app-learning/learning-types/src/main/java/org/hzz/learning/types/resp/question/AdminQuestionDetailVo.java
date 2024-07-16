package org.hzz.learning.types.resp.question;

import com.alibaba.fastjson2.annotation.JSONField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.hzz.fastjson2.enums.BaseEnumWriter;
import org.hzz.learning.types.enums.question.QuestionStatus;

import java.time.LocalDateTime;

/**
 * admin分页查询结果
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Data
public class AdminQuestionDetailVo {
    @Schema(description = "主键，互动问题的id")
    private Long id;

    @Schema(description = "互动问题的标题")
    private String title;

    @Schema(description = "问题描述信息")
    private String description;

    @Schema(description = "问题下的回答数量")
    private Integer answerTimes;

    @Schema(description = "提问时间")
    private LocalDateTime createTime;

    @Schema(description = "是否被隐藏，默认false")
    private Boolean hidden;

    @Schema(description = "管理端问题状态：0-未查看，1-已查看")
    @JSONField(serializeUsing = BaseEnumWriter.class)
    private QuestionStatus status;

    @Schema(description = "提问者昵称")
    private String username;

    @Schema(description = "课程名称")
    private String courseName;

    @Schema(description = "分类名称1/分类名称2/分类名称3")
    private String categoryName;

    @Schema(description = "章名称")
    private String chapterName;

    @Schema(description = "小节名称")
    private String sectionName;

    @Schema(description = "教师名称")
    private String teacherName;
}
