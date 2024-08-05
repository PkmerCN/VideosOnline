package org.hzz.points.api.season;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.hzz.core.result.Result;
import org.hzz.points.types.resp.SeasonVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@RequestMapping("/seasons")
public interface SeasonApi {

    /**
     * 获取全部赛季数据
     */
    @Operation(description = "获取全部历史赛季数据")
    @ApiResponse
    @GetMapping("/list")
    Result<List<SeasonVo>> getAllSeason();


    /**
     * 持久化上一个赛季
     */
    @Operation(description = "持久化上一个赛季")
    @GetMapping("/persistent")
    Result<Void> persistentSeason();
}
