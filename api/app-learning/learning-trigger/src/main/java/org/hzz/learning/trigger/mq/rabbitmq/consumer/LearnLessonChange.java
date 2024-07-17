package org.hzz.learning.trigger.mq.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import lombok.Setter;
import org.hzz.ddd.core.domain.shared.event.DomainEventBus;
import org.hzz.learning.domain.event.LearningLessonAddEvent;
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

import static org.hzz.learning.types.constants.RabbitMqConstants.Queue.*;
import static org.hzz.learning.types.constants.RabbitMqConstants.Key.*;
import static org.hzz.order.types.constant.Constants.Exchange.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Component
public class LearnLessonChange {
    private final Logger logger = LoggerFactory.getLogger(LearnLessonChange.class);

    @Setter(onMethod_ = {@Autowired,@Qualifier("learningEventPublisher")})
    private DomainEventBus eventBus;

    /**
     * 课程支付成功，接收添加课程消息
     * @param event 课程添加事件
     * @param channel Rabbitmq channel 用于手动提交ack
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue( value = LEARNING_LESSON_PAY_QUEUE,durable = "true"),
                    exchange = @Exchange(name = ORDER_EXCHANGE),
                    key = LESSON_PAY_KEY
            )
    })
    public void handlePayLesson(@Payload LearningLessonAddEvent event,
                                Channel channel,
                                @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {
        logger.info("接收到支付课程消息 AT {}",event.occurredOn());
        try{
            eventBus.publishDomainEvent(event);
            // 发布事件还是单线程执行，只不过是代码解耦了而已。
            // 所以监听该事件做完业务之后，才回到这里，进行ack
            channel.basicAck(tag,false);
            logger.info("ack 消息 success");
        }catch (DuplicateKeyException ex){
            // 幂等性控制，数据库唯一键unique key发挥作用
            logger.info("重复消费消息{}",event.toString());
            channel.basicAck(tag,false);
        }catch (Exception ex){
            logger.info("业务异常，回退消息{}",event.toString());
            channel.basicNack(tag,false,true);
            throw ex;
        }
    }
}
