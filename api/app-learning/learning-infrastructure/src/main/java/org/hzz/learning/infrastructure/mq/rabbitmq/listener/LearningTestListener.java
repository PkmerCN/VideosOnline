package org.hzz.learning.infrastructure.mq.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.hzz.learning.infrastructure.mq.rabbitmq.constants.RabbitmqConstants;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
@Component
@Slf4j
public class LearningTestListener {
    public LearningTestListener(){
        log.info("LearningTestListener已经生效");
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name= RabbitmqConstants.Queue.LEARNING_TEST_QUEUE,durable = "true"),
            exchange = @Exchange(name=RabbitmqConstants.Exchange.LEARNING_EXCHANGE,type = ExchangeTypes.DIRECT),
            key = RabbitmqConstants.RoutingKey.LEARNING_TEST_KEY
    ))
    public void listenTest(Message message){
        log.info("接收到消息: {}",message);
//        throw new RuntimeException("处理消息失败");
    }
}
