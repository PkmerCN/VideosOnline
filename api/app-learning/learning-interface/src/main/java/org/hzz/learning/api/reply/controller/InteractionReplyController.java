package org.hzz.learning.api.reply.controller;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import io.gitee.pkmer.common.collection.CollUtil;
import io.gitee.pkmer.common.tree.BaseConverter;
import io.gitee.pkmer.convention.controller.BaseController;
import io.gitee.pkmer.convention.exception.arg.AppArgumentNotValidException;
import io.gitee.pkmer.convention.page.PageResponse;
import io.gitee.pkmer.convention.result.Result;
import org.hzz.learning.api.reply.InteractionReplyApi;
import org.hzz.learning.application.command.reply.CommitReplyCommand;
import org.hzz.learning.application.command.reply.PageQueryReplyCommand;
import org.hzz.learning.application.service.LessonCmdService;
import org.hzz.learning.types.req.reply.ReplyPage;
import org.hzz.learning.types.req.reply.ReplyReq;
import org.hzz.learning.types.resp.reply.ReplyResp;
import io.gitee.pkmer.security.context.AppContextHolder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@RestController
@RequiredArgsConstructor
public class InteractionReplyController
        extends BaseController
        implements InteractionReplyApi {


    private final Validator validator;
    private final LessonCmdService cmdService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Result<Void> saveReply(ReplyReq replyReq) {
        logger.info("处理提交评论");
        validateReplyReq(replyReq);

        CommitReplyCommand cmd = Converter.INSTANCE.convert(replyReq);
        // user_id
        cmd.setUserId(AppContextHolder.userContextHolder.getUser().getId());
        cmdService.handleCommand(cmd);
        return success(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Result<PageResponse<ReplyResp>> page(ReplyPage replyPage) {

        if (replyPage.isComment()) {
            logger.info("准备分页查询评论");
        } else {
            logger.info("准备分页查询回复");
        }

        PageQueryReplyCommand cmd = new PageQueryReplyCommand();
        cmd.setAnswerId(replyPage.getAnswerId())
                .setQuestionId(replyPage.getQuestionId())
                .setPageQuery(replyPage);

        PageResponse<ReplyResp> replyRespPageResponse = cmdService
                .<PageResponse<ReplyResp>>handleCommandWithResult(cmd);

        return success(replyRespPageResponse);
    }

    private void validateReplyReq(ReplyReq replyReq) {
        Set<ConstraintViolation<ReplyReq>> sets;
        // 手动分组校验
        if (replyReq.isComment()) {
            logger.info("校验评论的参数");
            sets = validator.validate(replyReq, ReplyReq.CommentGroup.class);

        } else {
            logger.info("校验回复的参数");
            sets = validator.validate(replyReq, ReplyReq.ReplyGroup.class);
        }

        if (CollUtil.isNotEmpty(sets)) {
            // http://localhost:8080/learning-records
            String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
            // /replies
            String path = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
            logger.info("请求路径: {} 参数校验不合法", path);
            throw new AppArgumentNotValidException(sets);
        }
    }


    @Mapper
    interface Converter extends BaseConverter<CommitReplyCommand, ReplyReq> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
