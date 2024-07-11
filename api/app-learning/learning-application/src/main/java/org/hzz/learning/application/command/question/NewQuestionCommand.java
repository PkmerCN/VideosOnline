package org.hzz.learning.application.command.question;

import lombok.Data;
import lombok.Value;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;

/**
 * 新增问题命令
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Data
@Value(staticConstructor = "commandOf")
public class NewQuestionCommand implements CommandWithMark {
    // 互动问题的标题
    String title;

    // 问题描述信息
    String description;

    // 所属课程id
    Long courseId;

    // 所属课程章id
    Long chapterId;

    // 所属课程节id
    Long sectionId;

    // 提问学员id
    Long userId;

    public static final String MASK = NewQuestionCommand.class.getName();
    @Override
    public String mark() {
        return MASK;
    }
}
