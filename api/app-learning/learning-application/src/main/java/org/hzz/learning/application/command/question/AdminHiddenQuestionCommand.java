package org.hzz.learning.application.command.question;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.question.AdminHiddenQuestionCommandHandler;

/**
 * Admin隐藏问题
 * {@link AdminHiddenQuestionCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Data
@Accessors(chain = true)
public class AdminHiddenQuestionCommand implements CommandWithMark {
    public static final String MARK = AdminHiddenQuestionCommand.class.getName();

    private Long id;
    private Boolean hidden;

    @Override
    public String mark() {
        return MARK;
    }

}
