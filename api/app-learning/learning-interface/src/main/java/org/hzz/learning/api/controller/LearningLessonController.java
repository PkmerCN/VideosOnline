package org.hzz.learning.api.controller;

import lombok.Setter;
import org.hzz.aop.annotations.AddUserIdFilterCondition;
import org.hzz.core.controller.BaseController;
import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.PageQuery;
import org.hzz.core.result.Result;
import org.hzz.learning.api.LearningLessonApi;
import org.hzz.learning.api.req.LearnPlanReq;
import org.hzz.learning.application.command.LearnPlansAddCommand;
import org.hzz.learning.application.service.AppHandleCmdService;
import org.hzz.learning.application.service.AppLearningLessonService;
import org.hzz.learning.application.command.PageQueryCommand;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.security.context.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@RestController
public class LearningLessonController extends BaseController implements LearningLessonApi {
    @Setter(onMethod_ = @Autowired)
    private AppLearningLessonService appLearningLessonService;

    @Setter(onMethod_ = @Autowired)
    private AppHandleCmdService appHandleCmdService;
    @Override
    @AddUserIdFilterCondition
    public Result<PageResponse<LearningLessonAggregate>> queryUserLessons(PageQuery pageQuery) {
        logger.info("分页查询用户课程");
        System.out.println(pageQuery.toString());
        PageQueryCommand pageQueryCommand = PageQueryCommand.commandOf(pageQuery);
        return success(appLearningLessonService.pageQueryLesson(pageQueryCommand));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result<Object> createLearnPlans(LearnPlanReq req) {
        LearnPlansAddCommand command = LearnPlansAddCommand.commandOf(
                AppContextHolder.userContextHolder.getUser().getId(),
                req.getCouseId(),
                req.getFreq()
        );

        appHandleCmdService.handleCommand(command);
        return success(null);
    }
}
