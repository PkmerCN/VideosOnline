package org.hzz.learning.application.command.question;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.types.req.question.QuestionPageQuery;

/**
 * 问题分页查询
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
public class QuestionPageQueryCommand implements CommandWithMark {
    public static final String MARK = QuestionPageQueryCommand.class.getName();
    QuestionPageQuery pageQuery;
    @Override
    public String mark() {
        return MARK;
    }
}
