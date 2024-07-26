package org.hzz.learning.types.resp.reply;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/20
 */
@Data
@Schema(description = "回复查询")
public class ReplyResp {

    @Schema(description = "回答id")
    private Long id;

    @Schema(description = "回答内容")
    private String content;

    @Schema(description = "是否匿名，默认false,匿名用户不没有用户信息")
    private Boolean anonymity;

    @Schema(description = "评论数量")
    private Integer replyTimes;

    @Schema(description = "是否点过赞 ")
    private Boolean liked;

    @Schema(description = "点赞数量")
    private Integer likedTimes;

    @Schema(description = "回答时间")
    private LocalDateTime createTime;

    @Schema(description = "是否被隐藏，默认false,主要用户与admin端，用户端查询出来的都是false")
    private Boolean hidden = false;

    @Schema(description = "回答问题的用户信息，匿名用户没有用户信息 返回为null")
    private ReplyUserResp replyUser;

    @Schema(description = "评论时的目标用户，也就是说回复的是谁（只有评论才有，回复没有）")
    private String targetUserName;

}
