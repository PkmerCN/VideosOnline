package org.hzz.points.trigger.mq.rabbitmq.consumer;

import lombok.extern.slf4j.Slf4j;
import org.hzz.points.trigger.mq.rabbitmq.config.RabbitMqConfig;
import org.hzz.rabbitmq.constants.rabbitmq.video.PointsMqConstants;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
@Component
@Slf4j
public class PointsListener {

// todo 写笔记，对比绑定方式
//    @RabbitListeners({
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.WRITE_REPLY,durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.WRITE_REPLY
//                    )
//            }),
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.SIGN_IN,durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.SIGN_IN
//                    )
//            }),
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.LEARN_SECTION,durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.LEARN_SECTION
//                    )
//            }),
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.WRITE_NOTE,durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.WRITE_NOTE
//                    )
//            }),
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.NOTE_GATHERED,durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.NOTE_GATHERED
//                    )
//            })
//    })

    /**
     * 对应的queue bean {@link RabbitMqConfig}
     */
    @RabbitListener(queues = {
            PointsMqConstants.Queue.WRITE_REPLY,
            PointsMqConstants.Queue.SIGN_IN,
            PointsMqConstants.Queue.LEARN_SECTION,
            PointsMqConstants.Queue.WRITE_NOTE,
            PointsMqConstants.Queue.NOTE_GATHERED,

    })
    public void addPointsRecordListener(){
        log.info("收到消息");
    }
}
