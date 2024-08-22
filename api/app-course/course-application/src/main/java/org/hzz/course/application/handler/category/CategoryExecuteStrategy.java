package org.hzz.course.application.handler.category;

import io.gitee.pkmer.ddd.shared.command.CommandHandler;
import io.gitee.pkmer.ddd.shared.command.CommandWithMark;
import io.gitee.pkmer.designpattern.strategy.AbstractExecuteStrategy;
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
