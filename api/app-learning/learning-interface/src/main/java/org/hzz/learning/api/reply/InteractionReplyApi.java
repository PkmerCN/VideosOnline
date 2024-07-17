package org.hzz.learning.api.reply;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hzz.core.result.Result;
import org.hzz.learning.types.req.reply.ReplyReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 评论api
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Tag(name = "评论")
@RequestMapping("replies")
public interface InteractionReplyApi {

    /**
     * 评论api
     */
    @Operation(description = "提交评论")
    @PostMapping
    Result<Void> saveReply(@RequestBody ReplyReq replyReq);
}
