package org.hzz.learning.application.handler;

import org.hzz.ddd.core.domain.shared.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.LearnRecordCommitCommand;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Component
public class LearnRecordCommitCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<LearnRecordCommitCommand,Object> {
    @Override
    public String mark() {
        return MarkConstants.LEARN_LESSON_RECORD_COMMIT;
    }

    @Override
    public void execute(LearnRecordCommitCommand learnRecordCommitCommand) {

    }
}
