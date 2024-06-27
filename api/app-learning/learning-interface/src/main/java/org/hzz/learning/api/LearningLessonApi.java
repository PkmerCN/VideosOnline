package org.hzz.learning.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.core.page.query.PageQuery;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
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


    @Operation(summary = "分页查询用户课程",
            description = "分页查询用户课程")
    @GetMapping("/page")
    public void queryUserLessons(
            @Valid @RequestBody PageQuery pageQuery);
}
