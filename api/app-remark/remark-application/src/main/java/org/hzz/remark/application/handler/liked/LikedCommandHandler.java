package org.hzz.remark.application.handler.liked;

import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.remark.application.command.liked.LikedCommand;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Component
public class LikedCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<LikedCommand,Void> {
    @Override
    public String mark() {
        return LikedCommand.MARK;
    }

    @Override
    public void execute(LikedCommand command) {
    }
}
