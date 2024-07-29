package org.hzz.points.trigger.mq.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.hzz.rabbitmq.constants.rabbitmq.video.PointsMqConstants;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
@Component
@Slf4j
public class PointsListener {

    // todo 写笔记，对比绑定方式
    @RabbitListeners({
            @RabbitListener(bindings = {
                    @QueueBinding(
                            value = @Queue(name = PointsMqConstants.Queue.WRITE_REPLY, durable = "true"),
                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
                            key = PointsMqConstants.Key.WRITE_REPLY
                    )
            }),
            @RabbitListener(bindings = {
                    @QueueBinding(
                            value = @Queue(name = PointsMqConstants.Queue.SIGN_IN, durable = "true"),
                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
                            key = PointsMqConstants.Key.SIGN_IN
                    )
            }),
            @RabbitListener(bindings = {
                    @QueueBinding(
                            value = @Queue(name = PointsMqConstants.Queue.LEARN_SECTION, durable = "true"),
                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
                            key = PointsMqConstants.Key.LEARN_SECTION
                    )
            }),
            @RabbitListener(bindings = {
                    @QueueBinding(
                            value = @Queue(name = PointsMqConstants.Queue.WRITE_NOTE, durable = "true"),
                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
                            key = PointsMqConstants.Key.WRITE_NOTE
                    )
            }),
            @RabbitListener(bindings = {
                    @QueueBinding(
                            value = @Queue(name = PointsMqConstants.Queue.NOTE_GATHERED, durable = "true"),
                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
                            key = PointsMqConstants.Key.NOTE_GATHERED
                    )
            })
    })
    public void addPointsRecordListener(
            @Payload String msg,
            Channel channel,
            @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        log.info("收到消息: {}", msg);
        channel.basicAck(tag, false);
    }
}
