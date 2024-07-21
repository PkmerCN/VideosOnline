package org.hzz.learning.application.command.reply;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.core.page.query.PageQuery;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.learning.application.handler.reply.PageQueryReplyCommandHandler;

/**
 * 分页查询回答或者评论
 * {@link PageQueryReplyCommandHandler}
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/20
 */
@Data
@Accessors(chain = true)
public class PageQueryReplyCommand implements CommandWithMark {
    public static final String MARK = PageQueryReplyCommand.class.getName();

    private Long questionId;
    private Long answerId;
    // 标记是否用于admin分页查询（true），还是用户端查询(false)。
    private Boolean forAdmin = false;

    private PageQuery pageQuery;

    @Override
    public String mark() {
        return MARK;
    }

    /**
     * 判断是处理回答还是评论
     * @return true 评论; false 回答
     */
    public boolean isComment() {
        return answerId != null && answerId != 0;
    }
}
