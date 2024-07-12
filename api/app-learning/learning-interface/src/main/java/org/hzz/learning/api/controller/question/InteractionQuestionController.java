package org.hzz.learning.api.controller.question;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.exception.arg.AppArgumentNotValidException;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.api.InteractionQuestionApi;
import org.hzz.learning.api.req.question.ModifyQuestionReq;
import org.hzz.learning.api.req.question.NewQuestionReq;
import org.hzz.learning.application.command.question.ModifyQuestionCommand;
import org.hzz.learning.application.command.question.NewQuestionCommand;
import org.hzz.learning.application.command.question.QuestionPageQueryCommand;
import org.hzz.learning.application.service.AppHandleCmdService;
import org.hzz.learning.types.req.question.QuestionPageQuery;
import org.hzz.learning.types.resp.question.QuestionDto;
import org.hzz.security.context.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@RestController
public class InteractionQuestionController
        extends BaseController
        implements InteractionQuestionApi {

    @Setter(onMethod_ = @Autowired)
    private AppHandleCmdService cmdService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Result<Object> saveQuestion(NewQuestionReq questionReq) {
        logger.info("新增问题");
        NewQuestionCommand command = NewQuestionCommand.commandOf(
                questionReq.getTitle(),
                questionReq.getDescription(),
                questionReq.getCourseId(),
                questionReq.getChapterId(),
                questionReq.getSectionId(),
                AppContextHolder.userContextHolder.getUser().getId(),
                questionReq.getAnonymity()
        );

        cmdService.handleCommand(command);
        return success();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result<Object> modifyQuestion(Long id, ModifyQuestionReq modifyQuestionReq) {
        logger.info("修改问题");
        ModifyQuestionCommand command = new ModifyQuestionCommand();
        command.setId(id)
                .setTitle(modifyQuestionReq.getTitle())
                .setDescription(modifyQuestionReq.getDescription())
                .setAnonymity(modifyQuestionReq.getAnonymity())
                .setUserId(AppContextHolder.userContextHolder.getUser().getId());
        cmdService.handleCommand(command);
        return success();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result<PageResponse<QuestionDto>> questionPageQuery(QuestionPageQuery questionPageQuery) {
        logger.info("分页查询问题 ");
        if(questionPageQuery.getSectionId() == null && questionPageQuery.getCourseId() == null){
            throw new BadRequestException("sectionId与courseId必须要有一个有值");
        }

        QuestionPageQueryCommand command = QuestionPageQueryCommand.commandOf(questionPageQuery);

        PageResponse<QuestionDto> pageResponse = cmdService.<PageResponse<QuestionDto>>handleComandWithResult(command);
        return success(pageResponse);
    }
}
