package org.hzz.learning.api.question;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.core.page.PageResponse;
import org.hzz.core.result.Result;
import org.hzz.learning.types.req.question.ModifyQuestionReq;
import org.hzz.learning.types.req.question.NewQuestionReq;
import org.hzz.learning.types.req.question.QuestionPageQuery;
import org.hzz.learning.types.resp.question.QuestionDetailDto;
import org.hzz.learning.types.resp.question.QuestionDto;
import org.springframework.web.bind.annotation.*;

/**
 * 问答api
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Tag(name = "问答API")
@RequestMapping("/questions")
public interface InteractionQuestionApi {

    @Operation(description = "新增问题")
    @ApiResponse
    @PostMapping
    Result<Object> saveQuestion(@Valid @RequestBody NewQuestionReq questionReq);

    @Operation(description = "修改问题")
    @ApiResponse
    @PostMapping("/{id}")
    Result<Object> modifyQuestion(
            @Parameter(description = "问题id",example = "7217189651637997568")
            @PathVariable  Long id,
            @Valid @RequestBody ModifyQuestionReq modifyQuestionReq);

    @Operation(description = "分页查询问题")
    @ApiResponse
    @GetMapping("/page")
    Result<PageResponse<QuestionDto>> questionPageQuery(
            @RequestBody QuestionPageQuery questionPageQuery);


    @Operation(description = "获取问题详情")
    @ApiResponse
    @GetMapping("/{id}")
    Result<QuestionDetailDto> getQuestionById(
            @Parameter(description = "问题id")
            @PathVariable Long id
    );

    @Operation(description = "删除问题")
    @ApiResponse
    @DeleteMapping("/{id}")
    Result<Object> deleteQuestionById(
            @Parameter(description = "问题id")
            @PathVariable Long id
    );

}
