package org.hzz.points.api.points;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hzz.core.result.Result;
import org.hzz.points.types.resp.PointsStatisticsVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 积分api
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Tag(name = "积分api")
@RequestMapping("/points")
public interface PointsApi {

    @Operation(description = "获取用户今日积分情况")
    @GetMapping("/today")
    Result<List<PointsStatisticsVo>> queryUserPointsForToday();
}
