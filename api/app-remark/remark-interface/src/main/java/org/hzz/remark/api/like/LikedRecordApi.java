package org.hzz.remark.api.like;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.core.result.Result;
import org.hzz.remark.req.LikedReq;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Tag(name="点赞接口")
@RequestMapping("/likes")
public interface LikedRecordApi {

    /**
     * 处理点赞或者取消点赞
     * @param likedReq 点赞请求
     */
    @Operation(description = "处理点赞或者取消点赞")
    @PostMapping
    void handleLiked(
            @Valid
            @RequestBody LikedReq likedReq);

    /**
     * 查询用户对业务的点赞情况
     * @param bizIds 业务id集合
     */
    @Operation(description = "查询用户对业务的点赞情况")
    @GetMapping("/list")
    Result<Set<Long>> isBizLiked(
            @Parameter(description = "要检查的业务id集合")
            @RequestParam("bizIds") Set<Long> bizIds
    );
}
