package org.hzz.learning.types.resp.reply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 回答人信息
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/20
 */
@Data
@Schema(description = "回答用户信息")
public class ReplyUserResp {

    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "名字")
    private String name;

    @Schema(description = "头像地址")
    private String icon;
}
