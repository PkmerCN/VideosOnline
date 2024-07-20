package org.hzz.learning.application.handler.reply;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.common.tree.BaseConverter;
import org.hzz.core.page.PageResponse;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.reply.PageQueryReplyCommand;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.hzz.learning.types.resp.reply.ReplyResp;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * 分页查询
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/20
 */
@Component
public class PageQueryReplyCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<PageQueryReplyCommand, PageResponse<ReplyResp>> {

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyDomainService replyDomainService;

    @Override
    public String mark() {
        return null;
    }

    @Override
    public PageResponse<ReplyResp> executeWithResp(PageQueryReplyCommand command) {
        PageResponse<ReplyResp> pageResp = new PageResponse<>();
        // 分页
        PageResponse<InteractionReplyEntity> pageEntities = replyDomainService.selectReplyPage(command.getQuestionId(), command.getPageQuery());
//        Converter.INSTANCE.

        List<InteractionReplyEntity> entities = pageEntities.getList();

        if(CollUtil.isEmpty(entities)){
            pageResp.setList(Collections.emptyList());
            return pageResp;
        }

        return pageResp;
    }

    @Mapper
    interface Converter extends BaseConverter<ReplyResp,InteractionReplyEntity>{
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
