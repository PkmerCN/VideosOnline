package org.hzz.learning.application.command.plan;

import lombok.Data;
import lombok.Value;
import org.hzz.core.page.query.PageQuery;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;

/**
 * 分页查询学习计划
 * {@link org.hzz.learning.application.handler.plan.PlanPageQueryCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Data
@Value(staticConstructor = "commandOf")
public class PlanPageQueryCommand implements CommandWithMark {
    public final static String MARK = PlanPageQueryCommand.class.getName();

    PageQuery pageQuery;
    Long userId;

    @Override
    public String mark() {
        return MARK;
    }
}
