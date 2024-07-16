package org.hzz.learning.application.command.reply;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.reply.CommitReplyCommandHandler;

/**
 * 回复或者评论
 * {@link CommitReplyCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Data
@Accessors(chain = true)
public class CommitReplyCommand implements CommandWithMark {
    public static final String MARK = CommitReplyCommand.class.getName();
    // 互动问题问题id
    private Long questionId;

    // 回答内容
    private String content;

    // 是否匿名，默认false
    private Boolean anonymity;

    // 回答者id
    private Long userId;



    // 回复的上级回答id 针对的是评论
    private Long answerId;

    // 回复的目标用户id 针对的是用户
    private Long targetUserId;

    // 回复的目标回复id
    private Long targetReplyId;

    // 是否是学生
    private Boolean isStudent;

    @Override
    public String mark() {
        return MARK;
    }
}
