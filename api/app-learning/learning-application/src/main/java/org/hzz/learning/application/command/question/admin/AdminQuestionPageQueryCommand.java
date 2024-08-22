package org.hzz.learning.application.command.question.admin;

import lombok.Data;
import io.gitee.pkmer.convention.page.query.PageQuery;
import io.gitee.pkmer.ddd.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.question.admin.AdminQuestionPageQueryCommandHandler;
import org.hzz.learning.types.enums.question.QuestionStatus;

import java.time.LocalDateTime;

/**
 * admin分页查询问题
 * {@link AdminQuestionPageQueryCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Data
public class AdminQuestionPageQueryCommand implements CommandWithMark {
    public static final String MARK = AdminQuestionPageQueryCommand.class.getName();

    String courseName;
    QuestionStatus status;
    LocalDateTime beginTime;
    LocalDateTime endTime;

    PageQuery pageQuery;

    public static AdminQuestionPageQueryCommand commandOf(
            String courseName,
            QuestionStatus status,
            LocalDateTime beginTime,
            LocalDateTime endTime,
            PageQuery pageQuery) {

        AdminQuestionPageQueryCommand command = new AdminQuestionPageQueryCommand();
        command.setCourseName(courseName);
        command.setPageQuery(pageQuery);
        command.setStatus(status);
        command.setBeginTime(beginTime);
        command.setEndTime(endTime);

        return command;
    }

    @Override
    public String mark() {
        return MARK;
    }
}
