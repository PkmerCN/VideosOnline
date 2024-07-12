package org.hzz.learning.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.core.result.Result;
import org.hzz.learning.api.req.question.ModifyQuestionReq;
import org.hzz.learning.api.req.question.NewQuestionReq;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
