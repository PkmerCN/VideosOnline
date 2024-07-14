package org.hzz.learning.api.lesson;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.PageQuery;
import org.hzz.core.result.Result;
import org.hzz.learning.api.req.LearnPlanReq;
import org.hzz.learning.application.resp.LearnLessonDto;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.learning.types.resp.plan.LearnPlansPageResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@RequestMapping("/learn")
@Validated
@Tag(name = "learning lessong api",description = "用户课程相关api")
public interface LearningLessonApi {


    /**
     * 分页查询用户课程
     * @param pageQuery
     * @return
     */
    @Operation(summary = "分页查询用户课程",
            description = "分页查询用户课程")
    @GetMapping("/page")
    @ApiResponses
    Result<PageResponse<LearnLessonDto>> queryUserLessons(
            @Valid @RequestBody PageQuery pageQuery);

    /**
     * 添加学习计划
     */
    @ApiResponses
    @Operation(summary = "添加学习计划",
            description = "添加学习计划")
    @PostMapping("/plans")
    Result<Object> createLearnPlans(
            @Parameter(description = "学习计划")
            @Valid
            @RequestBody
            LearnPlanReq req);


    /**
     * 分页查询用户学习计划
     * @param pageQuery
     * @return
     */
    @ApiResponses
    @Operation(summary = "分页查询用户学习计划",
            description = "分页查询用户学习计划")
    @GetMapping("/plans")
     Result<LearnPlansPageResult> queryUserPlans(
            @Valid @RequestBody PageQuery pageQuery
    );
}
