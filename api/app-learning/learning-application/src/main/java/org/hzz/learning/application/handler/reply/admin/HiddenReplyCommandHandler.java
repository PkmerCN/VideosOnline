package org.hzz.learning.application.handler.reply.admin;

import lombok.Setter;
import org.hzz.core.exception.db.AppDbEntityNotFoundException;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.reply.admin.HiddenReplyCommand;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/21
 */
@Component
public class HiddenReplyCommandHandler
        implements CommandHandler,
        AbstractExecuteStrategy<HiddenReplyCommand,Void> {

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyDomainService replyDomainService;

    @Override
    public String mark() {
        return HiddenReplyCommand.MARK;
    }

    @Override
    public void execute(HiddenReplyCommand command) {
        InteractionReplyEntity replyEntity = replyDomainService.getEntityById(command.getId());
        if(replyEntity != null){
            replyEntity.setHidden(command.getHidden());
            replyDomainService.updateEntity(replyEntity);
        }
        throw new AppDbEntityNotFoundException("id = "+command.getId() + "错误，不存在");
    }
}
