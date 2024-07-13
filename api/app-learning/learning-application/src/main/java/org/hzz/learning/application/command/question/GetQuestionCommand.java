package org.hzz.learning.application.command.question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.question.GetQuestionCommandHandler;

/**
 * 获取问题详情
 * {@link GetQuestionCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetQuestionCommand implements CommandWithMark {
    Long id;
    public static final String MARK = GetQuestionCommand.class.getName();
    @Override
    public String mark() {
        return MARK;
    }
}
