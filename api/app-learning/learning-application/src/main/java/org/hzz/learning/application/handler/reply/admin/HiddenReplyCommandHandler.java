package org.hzz.learning.application.handler.reply.admin;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class HiddenReplyCommandHandler
        implements CommandHandler,
        AbstractExecuteStrategy<HiddenReplyCommand,Void> {

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyDomainService replyDomainService;

    @Override
    public String mark() {
        return HiddenReplyCommand.MARK;
    }

    /**
     * {
     * 	"code": 5002,
     * 	"msg": "id = 7219244721317744640错误，不存在",
     * 	"data": null
     * }
     */
    @Override
    public void execute(HiddenReplyCommand command) {
        InteractionReplyEntity replyEntity = replyDomainService.getEntityById(command.getId());
        if(replyEntity == null){
            throw new AppDbEntityNotFoundException("id = "+command.getId() + "错误，不存在");
        }

        if(!replyEntity.getHidden().equals(command.getHidden())){
            // 状态不一样才进行更新
            log.info("状态不一样，进行更新 old = {} new = {}",replyEntity.getHidden(),command.getHidden());
            replyEntity.setHidden(command.getHidden());
            replyDomainService.updateEntity(replyEntity);
        }
    }
}
