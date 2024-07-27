package org.hzz.learning.trigger.mq.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import lombok.Setter;
import org.hzz.ddd.core.domain.shared.event.DomainEventBus;
import org.hzz.learning.domain.event.ReplyLikedEvent;
import org.hzz.rabbitmq.constants.rabbitmq.VideoMqConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 监听rabbitmq点赞消息
 * 发送消息的地方
 * {@link org.hzz.remark.domain.service.impl.LikedRecordRedisDomainServiceImpl}
 * {@link org.hzz.remark.domain.service.impl.LikedRecordDomainServiceImpl}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Component
public class ReplyLikeTimesListener {
    private final Logger logger = LoggerFactory.getLogger(ReplyLikeTimesListener.class);

    @Setter(onMethod_ = {@Autowired,@Qualifier("learningEventPublisher")})
    private DomainEventBus eventBus;

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(name = VideoMqConstants.Queue.AQ_LIKED_TIMES_QUEUE, durable = "true"),
                    key = VideoMqConstants.Key.QA_LIKED_TIMES_KEY,
                    exchange = @Exchange(VideoMqConstants.Exchange.LIKE_RECORD_EXCHANGE)
            )}
    )
    public void handleLikeTimes(@Payload ReplyLikedEvent event,
                                Channel channel,
                                @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        logger.info("接收到点赞消息 AT {}",event.occurredOn());
        try{
            eventBus.publishDomainEvent(event);
            // 发布事件还是单线程执行，只不过是代码解耦了而已。
            // 所以监听该事件做完业务之后，才回到这里，进行ack
            channel.basicAck(tag,false);
            logger.info("ack 消息 success");
        }catch (Exception ex){
            logger.info("业务异常，回退消息{}",event.toString());
            channel.basicNack(tag,false,true);
            throw ex;
        }
    }
}
