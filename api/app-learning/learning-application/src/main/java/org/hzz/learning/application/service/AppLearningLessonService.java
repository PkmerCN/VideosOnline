package org.hzz.learning.application.service;

import org.hzz.core.page.PageResponse;
import org.hzz.learning.application.command.LearnLessonRecordCommand;
import org.hzz.learning.application.command.LearnRecordCommitCommand;
import org.hzz.learning.application.command.PageQueryCommand;
import org.hzz.learning.application.resp.LearnLessonRecordDto;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public interface AppLearningLessonService {

    PageResponse<LearningLessonAggregate> pageQueryLesson(PageQueryCommand command);

    LearnLessonRecordDto queryLearningRecord(LearnLessonRecordCommand command);

    void commitLearnLesssonRecord(LearnRecordCommitCommand command);
}
