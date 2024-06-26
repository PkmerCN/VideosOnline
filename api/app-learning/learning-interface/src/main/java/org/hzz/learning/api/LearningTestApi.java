package org.hzz.learning.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.hzz.core.result.Result;
import org.hzz.learning.domain.event.LearningLessonAddEvent;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
@RequestMapping("/learning-test")
@Tag(name="测试learning",description = "测试learning相关功能")
@Validated
public interface LearningTestApi {

    @Operation(summary = "测试mq",
            description = "发送数据到mq")
    @GetMapping("/mq")
    Result<String> sendMsg(
            @NotNull(message = "msg不能为空")
            @RequestParam(value = "msg")
            String msg);

    @Operation(summary = "发送下单数据",
            description = "测试领域事件模型")
    @GetMapping("/pay")
    Result<LearningLessonAddEvent> sendPayLesson(
            @RequestParam(name = "userId",required = true)
            Long userId);
}
