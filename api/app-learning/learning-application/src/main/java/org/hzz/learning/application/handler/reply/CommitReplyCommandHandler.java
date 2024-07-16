package org.hzz.learning.application.handler.reply;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.tree.BaseConverter;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.reply.CommitReplyCommand;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class CommitReplyCommandHandler
        implements CommandHandler,
        AbstractExecuteStrategy<CommitReplyCommand,Void>

{

    private final InteractionReplyDomainService replyDomainService;
    private final InteractionQuestionDomainService questionDomainService;

    /**
     * 避免事务失效
     */
    @Autowired
    @Lazy
    private CommitReplyCommandHandler self;

    @Override
    public String mark() {
        return CommitReplyCommand.MARK;
    }

    @Override
    public void execute(CommitReplyCommand command) {
        InteractionReplyEntity entity = CommitReplyCommandConverter.INSTANCE.convert(command);

        if(entity.isComment()){
            // 处理评论
            self.handleComment(entity);
        }else{
            // 回答

        }


        if(command.getIsStudent()){
            // todo 发送积分rabbit
        }
    }




    /**
     * 处理评论
     */
    @Transactional
    public void handleComment(InteractionReplyEntity currentComment){
        replyDomainService.commitReply(currentComment);
        // 更新父评论
        replyDomainService.incrReplyTimes(currentComment.getAnswerId());
    }


    /**
     * 处理回复
     */
    private void handleReply(InteractionReplyEntity currentReply,Long questionId){
        // todo 能拿到id吗
        replyDomainService.commitReply(currentReply);
        // 更新问题 todo 用sql更新，不要在代码里面做。
        questionDomainService.addAnswer(questionId,currentReply.getId());
    }



    @Mapper
    interface CommitReplyCommandConverter
            extends BaseConverter<InteractionReplyEntity,CommitReplyCommand>{
        CommitReplyCommandConverter INSTANCE = Mappers.getMapper(CommitReplyCommandConverter.class);
    }
}
