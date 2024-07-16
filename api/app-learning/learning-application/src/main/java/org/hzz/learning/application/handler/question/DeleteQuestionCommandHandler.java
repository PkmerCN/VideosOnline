package org.hzz.learning.application.handler.question;

import lombok.Setter;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.DeleteQuestionCommand;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 处理删除问题
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Component
public class DeleteQuestionCommandHandler implements CommandHandler
    , AbstractExecuteStrategy<DeleteQuestionCommand,Void> {

    @Setter(onMethod_ = {@Autowired})
    private InteractionQuestionDomainService questionDomainService;
    @Setter(onMethod_ = {@Autowired})
    private InteractionReplyDomainService replyDomainService;

    /**
     * 删除问题
     * 判断是否是登录用户提的问题
     * 删除问题下的评论
     */
    @Override
    public void execute(DeleteQuestionCommand command) {
        Long questionId = command.getQuestionId();
        Long userId = command.getUserId();
        InteractionQuestionEntity question = questionDomainService.getEntityById(questionId);

        // 判断是否是用户提的问题
        if(userId.equals(question.getUserId())) {
            throw new BadRequestException("不是你提的问题");
        }

        replyDomainService.deleteReplyByQuestionId(questionId);
    }



    @Override
    public String mark() {
        return DeleteQuestionCommand.MARK;
    }
}
