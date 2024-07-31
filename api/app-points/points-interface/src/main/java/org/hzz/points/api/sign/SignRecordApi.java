package org.hzz.points.api.sign;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.hzz.core.result.Result;
import org.hzz.points.types.resp.SignResultVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/28
 */
@RequestMapping("/sign-records")
public interface SignRecordApi {

    /**
     * 签到
     */
    @Operation(description = "签到")
    @ApiResponse
    @PostMapping
    Result<SignResultVo> addSignRecord();

    /**
     * 查询签到记录
     */
    @Operation(description = "查询签到记录")
    @ApiResponse
    @GetMapping
    Result<int[]> querySignRecords();
}
