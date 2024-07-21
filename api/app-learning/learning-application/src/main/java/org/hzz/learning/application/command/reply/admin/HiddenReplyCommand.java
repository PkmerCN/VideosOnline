package org.hzz.learning.application.command.reply.admin;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.reply.admin.HiddenReplyCommandHandler;

/**
 * 显示或者隐藏评论或回复
 * {@link HiddenReplyCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/21
 */
@Data
@Accessors(chain = true)
public class HiddenReplyCommand implements CommandWithMark {
    public final static String MARK = HiddenReplyCommand.class.getName();

    private Long id;
    private Boolean hidden;

    @Override
    public String mark() {
        return MARK;
    }
}
