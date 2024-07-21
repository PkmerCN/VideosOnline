package org.hzz.learning.api.reply;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.types.req.reply.ReplyPage;
import org.hzz.learning.types.req.reply.ReplyReq;
import org.hzz.learning.types.resp.reply.ReplyResp;
import org.springframework.web.bind.annotation.*;

/**
 * admin评论api
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Tag(name = "admin评论相关API")
@RequestMapping("/admin/replies")
public interface AdminInteractionReplyApi {

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

    /**
     * 设置评论或者回复隐藏还是显示
     */
    @Operation(description = "设置评论或者回复隐藏还是显示")
    @PutMapping("/{id}/hidden/{hidden}")
    Result<Void> hiddenReply(
            @Parameter(description = "评论或者回复id")
            @PathVariable("id") Long id,
            @Parameter(description = "设置是隐藏还是显示",example = "true")
            @PathVariable("hidden") Boolean hidden
    );
}
