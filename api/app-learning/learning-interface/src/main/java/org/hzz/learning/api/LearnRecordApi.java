package org.hzz.learning.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.core.result.Result;
import org.hzz.learning.api.req.LearningRecordFormRequest;
import org.hzz.learning.application.resp.LearnLessonRecordDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 学习记录API
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@RequestMapping("/learning-records")
@Tag(name = "学习记录API",description = "学习记录相关API")
public interface LearnRecordApi {

    @Operation(description = "查询用户课程的学习记录（也就是课程小节学习进度）")
    @ApiResponse
    @GetMapping("/course/{courseId}")
    Result<LearnLessonRecordDto> queryLearningRecordByCourseId(
            @Parameter(description = "课程id")
            @PathVariable("courseId") Long courseId);

    /**
     * 这里不通过方法参数加@Validated
     * 因为我想实现通用，所以在实现类做手动参数校验
     * @param request
     * @return
     */
    @Operation(description = "提交用户课程的学习记录（也就是课程小节学习进度）")
    @ApiResponse
    @PostMapping
    Result<Object> commitLearnRecord(@Parameter
//                                     @Validated(LearningRecordFormRequest.VideoGroup.class)
                                     @RequestBody LearningRecordFormRequest request);

}
