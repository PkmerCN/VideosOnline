package org.hzz.learning.application.handler.reply;

import org.hzz.core.page.PageResponse;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.reply.PageQueryReplyCommand;
import org.hzz.learning.types.resp.reply.ReplyResp;
import org.springframework.stereotype.Component;

/**
 * 分页查询
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/20
 */
@Component
public class PageQueryReplyCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<PageQueryReplyCommand, PageResponse<ReplyResp>> {
    @Override
    public String mark() {
        return null;
    }

    @Override
    public PageResponse<ReplyResp> executeWithResp(PageQueryReplyCommand command) {


        return null;
    }
}
