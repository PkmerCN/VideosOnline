package org.hzz.learning.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    public String sendMsg(
            @Valid
            @NotNull(message = "msg不能为空")
            @RequestParam(value = "msg",required = true)
            String msg,
            @Valid
            @NotNull(message = "tag不能为空")
            @RequestParam(value = "tag",required = true)
            String tag);
}
