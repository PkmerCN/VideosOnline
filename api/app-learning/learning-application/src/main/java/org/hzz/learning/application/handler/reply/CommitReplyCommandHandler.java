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
            self.handleReply(entity);
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
    @Transactional
    public void handleReply(InteractionReplyEntity currentReply){
        log.info("插入数据库之前，当前回答Id = {}",currentReply.getId());
        /**
         *  能拿到id吗? 能：因为 {@link org.hzz.mybatis.core.SnowflakeIdPlugin}通过反射设置id
         */
        replyDomainService.commitReply(currentReply);
        log.info("插入数据库后，当前回答Id = {}",currentReply.getId());
        /**
         * 更新问题
         * 用sql更新 update replyTimes = replyTimes + 1，
         * 不要在java代码里面做 replyTimes + 1。
         */
        questionDomainService.addAnswer(currentReply.getQuestionId(),currentReply.getId());
    }



    @Mapper
    interface CommitReplyCommandConverter
            extends BaseConverter<InteractionReplyEntity,CommitReplyCommand>{
        CommitReplyCommandConverter INSTANCE = Mappers.getMapper(CommitReplyCommandConverter.class);
    }
}
