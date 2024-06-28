package org.hzz.learning.api.controller;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.learning.api.LearnRecordApi;
import org.hzz.learning.application.service.AppLearningLessonService;
import org.hzz.learning.application.service.command.LearnLessonRecordCommand;
import org.hzz.learning.application.service.resp.LearnLessonRecordDto;
import org.hzz.security.context.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@RestController
public class LearnRecordController extends BaseController implements LearnRecordApi {
    @Setter(onMethod_ = @Autowired)
    private AppLearningLessonService appLearningLessonService;
    @Override
    public Result<LearnLessonRecordDto> queryLearningRecordByCourseId(Long courseId) {
        logger.info("查询用户课程 {id = {}} 小节信息",courseId);
        LearnLessonRecordCommand command = LearnLessonRecordCommand.commandOf(
                AppContextHolder.userContextHolder.getUser().getId(),
                courseId);
        LearnLessonRecordDto learnLessonRecordDto = appLearningLessonService.queryLearningRecord(command);
        return success(learnLessonRecordDto);
    }
}