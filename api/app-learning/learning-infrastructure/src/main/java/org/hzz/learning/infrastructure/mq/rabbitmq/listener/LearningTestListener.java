package org.hzz.learning.infrastructure.mq.rabbitmq.listener;


import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.hzz.learning.infrastructure.mq.rabbitmq.constants.RabbitmqConstants;
import org.hzz.learning.infrastructure.mq.rabbitmq.model.TestData;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;


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
    public void listenTest(@Payload TestData payload,
                           Channel channel,
                           @Header("name") String name,
                           @Header(AmqpHeaders.DELIVERY_TAG) long tag,
                           @Header(AmqpHeaders.MESSAGE_ID)String id){
        try {
            log.info("payload = {},name = {},tag = {},message_id = {}",
                    payload,
                    name,
                    tag,id);

            channel.basicAck(tag,false);
        } catch (IOException e) {
            log.info("手动ack失败");
            throw new RuntimeException(e);
        }
    }
}
