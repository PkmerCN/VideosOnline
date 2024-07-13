package org.hzz.learning.application.command.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.question.DeleteQuestionCommandHandler;

/**
 * 删除问题
 * {@link DeleteQuestionCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteQuestionCommand implements CommandWithMark {
    public static final String MARK = DeleteQuestionCommand.class.getName();

    Long questionId;
    Long userId;
    @Override
    public String mark() {
        return MARK;
    }
}
