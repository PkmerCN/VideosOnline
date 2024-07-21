package org.hzz.learning.api.reply.controller;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.api.reply.AdminInteractionReplyApi;
import org.hzz.learning.application.command.reply.PageQueryReplyCommand;
import org.hzz.learning.application.service.LessonCmdService;
import org.hzz.learning.types.req.reply.ReplyPage;
import org.hzz.learning.types.resp.reply.ReplyResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/21
 */
@RestController
public class AdminInteractionReplyController
        extends BaseController
        implements AdminInteractionReplyApi {

    @Setter(onMethod_ = @Autowired)
    private LessonCmdService cmdService;

    @Override
    public Result<PageResponse<ReplyResp>> page(ReplyPage replyPage) {
        PageQueryReplyCommand cmd = new PageQueryReplyCommand();
        cmd.setAnswerId(replyPage.getAnswerId())
                .setQuestionId(replyPage.getQuestionId())
                // 用于admin查询
                .setForAdmin(true)
                .setPageQuery(replyPage);

        PageResponse<ReplyResp> replyRespPageResponse = cmdService
                .<PageResponse<ReplyResp>>handleCommandWithResult(cmd);
        return success(replyRespPageResponse);
    }

    @Override
    public Result<Void> hiddenReply(Long id, Boolean hidden) {
        return null;
    }
}
