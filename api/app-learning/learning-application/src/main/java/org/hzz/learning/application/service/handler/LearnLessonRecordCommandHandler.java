package org.hzz.learning.application.service.handler;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.service.command.LearnLessonRecordCommand;
import org.hzz.learning.application.service.resp.LearnRecordDto;
import org.hzz.learning.domain.aggregate.LearningLessonRecordAggregate;
import org.hzz.learning.domain.service.LearnLessonRecordDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 处理课程学习进度
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Component
public class LearnLessonRecordCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<LearnLessonRecordCommand, LearnRecordDto> {

    @Setter(onMethod_ = @Autowired)
    private LearnLessonRecordDomainService learnLessonRecordDomainService;

    @Override
    public String mark() {
        return MarkConstants.LEARN_LESSON_RECORD;
    }

    @Override
    public LearnRecordDto executeWithResp(LearnLessonRecordCommand command) {
        LearningLessonRecordAggregate aggregate = learnLessonRecordDomainService.queryLearnLessonRecord(
                command.getUserId(),
                command.getCourseId()
        );
        // todo
        return null;
    }
}
