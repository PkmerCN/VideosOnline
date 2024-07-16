package org.hzz.learning.application.service;

import org.hzz.core.page.PageResponse;
import org.hzz.learning.application.command.lesson.LearnLessonRecordCommand;
import org.hzz.learning.application.command.lesson.LearnRecordCommitCommand;
import org.hzz.learning.application.command.lesson.PageQueryCommand;
import org.hzz.learning.application.resp.LearnLessonDto;
import org.hzz.learning.application.resp.LearnLessonRecordDto;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public interface AppLearningLessonService {

    PageResponse<LearnLessonDto> pageQueryLesson(PageQueryCommand command);

    LearnLessonRecordDto queryLearningRecord(LearnLessonRecordCommand command);

    void commitLearnLesssonRecord(LearnRecordCommitCommand command);
    
}
