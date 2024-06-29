package org.hzz.learning.application.handler;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.LearnRecordCommitCommand;
import org.hzz.learning.domain.entity.LearnRecordEntity;
import org.hzz.learning.domain.enums.SectionType;
import org.hzz.learning.domain.service.LearnLessonRecordDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 处理学习记录提交
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Component
public class LearnRecordCommitCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<LearnRecordCommitCommand, Object> {

    @Setter(onMethod_ = @Autowired)
    private LearnLessonRecordDomainService learnLessonRecordDomainService;

    @Override
    public String mark() {
        return MarkConstants.LEARN_LESSON_RECORD_COMMIT;
    }

    @Override
    public void execute(LearnRecordCommitCommand command) {
        boolean finished = false;
        if (SectionType.EXAM == command.getSectionType()) {
            // 处理考试
            finished = handleExamRecord(command);
        } else if (SectionType.VIDEO == command.getSectionType()) {
            // 处理视频
//            handeVideoRecord()
        }


        // 课程表

    }

    /**
     * 提交
     *
     * @param command 命令
     * @return true 表示已经完成该小节
     */
    boolean handleExamRecord(LearnRecordCommitCommand command) {
        boolean finished = true;
        LearnRecordEntity entity = new LearnRecordEntity();

        entity.setUserId(command.getUserId())
                .setFinished(finished)
                .setFinishTime(LocalDateTime.now())
                .setLessonId(command.getLessonId())
                .setSectionId(command.getSectionId());

        learnLessonRecordDomainService.commitRecord(entity);
        return finished;
    }
}
