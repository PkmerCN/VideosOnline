package org.hzz.course.application.handler.category;

import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 分类抽象执行策略,
 * 统一标记为{@link CommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
public abstract class CategoryExecuteStrategy<T extends CommandWithMark,R>
        implements AbstractExecuteStrategy<T,R>,
        CommandHandler {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
}
