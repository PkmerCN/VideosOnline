package org.hzz.learning.application.command.reply;

import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.reply.PageQueryReplyCommandHandler;

/**
 * 分页查询回答或者评论
 * {@link PageQueryReplyCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/20
 */
public class PageQueryReplyCommand implements CommandWithMark {
    public static final String MARK = PageQueryReplyCommand.class.getName();
    @Override
    public String mark() {
        return MARK;
    }
}
