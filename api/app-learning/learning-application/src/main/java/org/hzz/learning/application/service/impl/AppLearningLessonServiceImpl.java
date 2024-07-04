package org.hzz.learning.application.service.impl;

import lombok.Setter;
import org.hzz.core.page.PageResponse;
import org.hzz.design.pattern.strategy.StrategyChoose;
import org.hzz.learning.application.command.LearnRecordCommitCommand;
import org.hzz.learning.application.command.PageQueryCommand;
import org.hzz.learning.application.handler.MarkConstants;
import org.hzz.learning.application.resp.LearnLessonDto;
import org.hzz.learning.application.resp.LearnLessonRecordDto;
import org.hzz.learning.application.service.AppLearningLessonService;
import org.hzz.learning.application.command.LearnLessonRecordCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@Service
public class AppLearningLessonServiceImpl implements AppLearningLessonService {
    @Setter(onMethod_ = @Autowired)
    private StrategyChoose strategyChoose;


    @Override
    public PageResponse<LearnLessonDto> pageQueryLesson(PageQueryCommand command) {
        return strategyChoose.<PageQueryCommand, PageResponse<LearnLessonDto>>
               chooseAndExecuteWithResp(MarkConstants.PAGE_QUERY, command);
    }

    @Override
    public LearnLessonRecordDto queryLearningRecord(LearnLessonRecordCommand command) {
        return strategyChoose.<LearnLessonRecordCommand, LearnLessonRecordDto>
                chooseAndExecuteWithResp(MarkConstants.LEARN_LESSON_RECORD, command);
    }

    @Override
    public void commitLearnLesssonRecord(LearnRecordCommitCommand command) {
       strategyChoose.chooseAndExecute(
                MarkConstants.LEARN_LESSON_RECORD_COMMIT
                ,command);
    }

}
