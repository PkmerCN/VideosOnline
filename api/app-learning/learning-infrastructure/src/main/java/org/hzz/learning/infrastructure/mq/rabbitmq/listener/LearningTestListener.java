package org.hzz.learning.infrastructure.mq.rabbitmq.listener;

import com.alibaba.fastjson2.JSON;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.hzz.learning.infrastructure.mq.rabbitmq.constants.RabbitmqConstants;
import org.hzz.learning.infrastructure.mq.rabbitmq.model.TestData;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
    public void listenTest(@Payload TestData payload){
//        byte[] body = message.getBody();
//        String s = new String(body);
//        log.info(s);
//        TestData testData = JSON.parseObject(s, TestData.class);
//        System.out.println(testData);


//        long tag = message.getMessageProperties().getHeader("deliveryTag");
        log.info("接收到消息: payload = {}",payload);
//        log.info("接收到消息: message = {} headers = {}",message,message.getMessageProperties().getHeaders());
//        try {
//            // 消息处理失败，进行 nack（否定确认）
//            channel.basicNack(tag, false, true);
//        } catch (IOException ex) {
//            log.error("发送 Nack 失败", ex);
//        }
    }
}
