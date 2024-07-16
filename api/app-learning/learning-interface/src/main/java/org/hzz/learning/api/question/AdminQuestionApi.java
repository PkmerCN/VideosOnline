package org.hzz.learning.api.question;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.types.req.question.AdminQuestionPageQuery;
import org.hzz.learning.types.resp.question.AdminQuestionDetailVo;
import org.springframework.web.bind.annotation.*;

/**
 * admin 问答api
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@RequestMapping("/admin/questions")
@Tag(name="admin 问答api")
public interface AdminQuestionApi {

    @Operation(description = "分页查询")
    @ApiResponse
    @GetMapping("/page")
    Result<PageResponse<AdminQuestionDetailVo>> questionPageQuery(
            @RequestBody
            AdminQuestionPageQuery pageQuery);

    @Operation(description = "设置问题隐藏")
    @ApiResponse
    @PutMapping("/{id}/hidden/{hidden}")
    Result<Void> hiddenQuestion(
            @Parameter(name = "问题id")
            @PathVariable("id") Long id,
            @Parameter(name = "是否隐藏问题")
            @PathVariable("hidden") Boolean hidden
    );

    @Operation(description = "获取问题详情")
    @ApiResponse
    @GetMapping("/{questionId}")
    Result<AdminQuestionDetailVo> getQuestionDetail(
            @Parameter(description = "问题id")
            @PathVariable("questionId") Long questionId);

}
