package org.hzz.learning.api.reply;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.types.req.reply.ReplyPage;
import org.hzz.learning.types.req.reply.ReplyReq;
import org.hzz.learning.types.resp.reply.ReplyResp;
import org.springframework.web.bind.annotation.GetMapping;
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
     * {
     *  "code": 2000,
     *  "msg": "成功",
     *  "data": null
     * }
     */
    @Operation(description = "提交评论")
    @PostMapping
    Result<Void> saveReply(@RequestBody ReplyReq replyReq);

    /**
     * 分页查询评论或者回复
     */
    @Operation(description = "分页查询评论或者回复")
    @ApiResponse
    @GetMapping("/page")
    Result<PageResponse<ReplyResp>> page(
            @Valid
            @RequestBody
            ReplyPage replyPage);
}
