package org.hzz.learning.application.command.question;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.question.ModifyQuestionCommandHandler;
/**
 * 修改问题命令 {@link ModifyQuestionCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
@Accessors(chain = true)
public class ModifyQuestionCommand implements CommandWithMark {
    public static final String MASK = ModifyQuestionCommand.class.getName();

    Long userId;
    // 问题id
    Long id;
    // 互动问题的标题
    String title;
    // 问题描述信息
    String description;
    // 是否匿名，默认false
    Boolean anonymity;

    @Override
    public String mark() {
        return MASK;
    }
}
