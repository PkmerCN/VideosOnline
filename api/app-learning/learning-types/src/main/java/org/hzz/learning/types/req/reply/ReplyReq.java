package org.hzz.learning.types.req.reply;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

/**
 * 评论
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Schema(description = "评论")
public class ReplyReq {
    // 评论分组
    interface CommentGroup{}
    // 回复分组
    interface ReplyGroup{}

    @Schema(description = "互动问题问题id")
    @NotNull(groups = {ReplyGroup.class,CommentGroup.class})
    private Long questionId;

    @Schema(description = "回答内容")
    @NotNull(groups = {ReplyGroup.class,CommentGroup.class})
    private String content;

    @Schema(description = "是否匿名，默认false")
    @NotNull(groups = {ReplyGroup.class,CommentGroup.class})
    private Boolean anonymity = false;

    @Schema(description = "回复的上级回答id 针对的是评论")
    @NotNull(groups = {CommentGroup.class})
    private Long answerId;

    @Schema(description = "回复的目标用户id (当前评论是针对哪一个用户的)")
    @NotNull(groups = {CommentGroup.class})
    private Long targetUserId;

    @Schema(description = "回复的目标回复id (当前评论是针对哪一条评论的)")
    @NotNull(groups = {CommentGroup.class})
    private Long targetReplyId;

    @Schema(description = "是否是学生")
    @NotNull(groups = {ReplyGroup.class,CommentGroup.class})
    private Boolean isStudent;
}
