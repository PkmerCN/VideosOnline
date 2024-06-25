package org.hzz.learning.trigger.mq.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.hzz.learning.domain.event.LearningLessonAddEvent;
import org.hzz.learning.types.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import static org.hzz.learning.types.constant.Constants.Queue.*;
import static org.hzz.learning.types.constant.Constants.Key.*;
import static org.hzz.order.types.constant.Constants.Exchange.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Component
public class LearnLessonChange {
    private final Logger logger = LoggerFactory.getLogger(LearnLessonChange.class);

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
                                @Header(AmqpHeaders.DELIVERY_TAG) long tag){
        logger.info("接收到支付课程消息 AT {}",event.occurredOn());



    }
}
