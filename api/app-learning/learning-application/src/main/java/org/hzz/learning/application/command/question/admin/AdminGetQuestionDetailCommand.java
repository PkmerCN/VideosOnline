package org.hzz.learning.application.command.question.admin;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.question.admin.AdminGetQuestionDetailCommandHandler;

/**
 * admin获取问题详情
 * {@link  AdminGetQuestionDetailCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Data
public class AdminGetQuestionDetailCommand implements CommandWithMark {
    public static final String MARK = AdminGetQuestionDetailCommand.class.getName();
    Long questionId;
    @Override
    public String mark() {
        return MARK;
    }
}
