package org.hzz.remark.api.like;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.hzz.remark.req.LikedReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public void handleLiked(
            @Valid
            @RequestBody LikedReq likedReq);
}
