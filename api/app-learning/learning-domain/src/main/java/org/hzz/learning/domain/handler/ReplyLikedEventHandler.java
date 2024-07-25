package org.hzz.learning.domain.handler;

import lombok.Setter;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.event.ReplyLikedEvent;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Component
public class ReplyLikedEventHandler {

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyDomainService replyDomainService;

    /**
     * 监听事件点赞次数
     * @param event 评论点赞事件
     */
    @EventListener
    public void listen(ReplyLikedEvent event){
        InteractionReplyEntity entity = new InteractionReplyEntity();
        entity.setId(event.getBizId()).setLikedTimes(event.getLikedTimes().intValue());
        replyDomainService.updateEntity(entity);
    }
}