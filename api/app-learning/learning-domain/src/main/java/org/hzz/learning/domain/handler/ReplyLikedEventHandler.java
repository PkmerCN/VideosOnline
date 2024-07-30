package org.hzz.learning.domain.handler;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.event.DomainEventHandler;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.event.ReplyLikedEvent;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.hzz.remark.types.LikedTimesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Component
public class ReplyLikedEventHandler implements DomainEventHandler<ReplyLikedEvent> {

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyDomainService replyDomainService;

    /**
     * 监听事件点赞次数
     * 事件发送的地方
     * {@link org.hzz.learning.trigger.mq.rabbitmq.consumer.ReplyLikeTimesListener}
     *
     * @param event 评论点赞事件
     */
    @EventListener
    public void listen(ReplyLikedEvent event){

        List<InteractionReplyEntity> entities = new ArrayList<>();
        for(LikedTimesDto dto: event.getLikeTimes()){
            InteractionReplyEntity entity = new InteractionReplyEntity();
            entity.setId(dto.getBizId()).setLikedTimes(dto.getLikedTimes().intValue());
            entities.add(entity);
        }

        if(!entities.isEmpty()){
            replyDomainService.updateLikedTimesBatchByIds(entities);
        }

    }
}
