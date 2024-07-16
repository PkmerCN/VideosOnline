package org.hzz.learning.api.question.controller;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.api.question.AdminQuestionApi;
import org.hzz.learning.application.command.question.admin.AdminHiddenQuestionCommand;
import org.hzz.learning.application.command.question.admin.AdminQuestionPageQueryCommand;
import org.hzz.learning.application.service.AppHandleCmdService;
import org.hzz.learning.types.req.question.AdminQuestionPageQuery;
import org.hzz.learning.types.resp.question.AdminQuestionDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@RestController
public class AdminQuestionController extends BaseController
    implements AdminQuestionApi
{

    @Setter(onMethod_ = @Autowired)
    private AppHandleCmdService cmdService;

    @Override
    public Result<PageResponse<AdminQuestionDetailVo>> questionPageQuery(AdminQuestionPageQuery pageQuery) {

        AdminQuestionPageQueryCommand command = AdminQuestionPageQueryCommand.commandOf(
                pageQuery.getCourseName(),
                pageQuery.getStatus(),
                pageQuery.getBeginTime(),
                pageQuery.getEndTime(),
                pageQuery
        );

        PageResponse<AdminQuestionDetailVo> result = cmdService
                .<PageResponse<AdminQuestionDetailVo>>handleComandWithResult(command);


        return success(result);
    }

    @Override
    public Result<Void> hiddenQuestion(Long id, Boolean hidden) {
        logger.info("设置 id = {} 的问题，的隐藏状态为: {}",id,hidden);

        AdminHiddenQuestionCommand cmd = new AdminHiddenQuestionCommand();
        cmd.setId(id).setHidden(hidden);
        cmdService.handleCommand(cmd);
        return success(null);
    }
}
