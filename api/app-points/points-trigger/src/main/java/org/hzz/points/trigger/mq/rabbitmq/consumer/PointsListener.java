package org.hzz.points.trigger.mq.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.hzz.core.converter.TargetAndSourceConverter;
import org.hzz.ddd.core.domain.shared.event.DomainEventBus;
import org.hzz.ddd.core.domain.shared.event.annotations.DDDBus;
import org.hzz.points.domain.event.AddPointsRecordEvent;
import org.hzz.points.trigger.mq.rabbitmq.config.RabbitMqConfig;
import org.hzz.points.types.dto.PointsRewardDto;
import org.hzz.rabbitmq.constants.rabbitmq.video.PointsMqConstants;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
    private final DomainEventBus domainEventBus;

    public PointsListener(@DDDBus DomainEventBus domainEventBus) {
        this.domainEventBus = domainEventBus;
    }


//    @RabbitListeners({
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.WRITE_REPLY, durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.WRITE_REPLY
//                    )
//            }),
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.SIGN_IN, durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.SIGN_IN
//                    )
//            }),
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.LEARN_SECTION, durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.LEARN_SECTION
//                    )
//            }),
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.WRITE_NOTE, durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.WRITE_NOTE
//                    )
//            }),
//            @RabbitListener(bindings = {
//                    @QueueBinding(
//                            value = @Queue(name = PointsMqConstants.Queue.NOTE_GATHERED, durable = "true"),
//                            exchange = @Exchange(PointsMqConstants.Exchange.POINTS_EXCHANGE),
//                            key = PointsMqConstants.Key.NOTE_GATHERED
//                    )
//            })
//    })

    /**
     * 这里使用绑定关系配置类，而不是像上面注解类的绑定配置
     * 对应的queue bean {@link RabbitMqConfig}
     */
    @RabbitListener(queues = {
            PointsMqConstants.Queue.WRITE_REPLY,
            PointsMqConstants.Queue.SIGN_IN,
            PointsMqConstants.Queue.LEARN_SECTION,
            PointsMqConstants.Queue.WRITE_NOTE,
            PointsMqConstants.Queue.NOTE_GATHERED,
    })
    public void addPointsRecordListener(
            @Payload PointsRewardDto pointsRewardDto,
            Channel channel,
            @Header(AmqpHeaders.DELIVERY_TAG) long tag) throws IOException {

        AddPointsRecordEvent event = convertTo(pointsRewardDto);

        try {
            domainEventBus.publishDomainEvent(event);
            channel.basicAck(tag, false);
            log.info("消费消息 success");
        } catch (Exception e) {
            log.info("业务异常，回退消息{}", pointsRewardDto);
            channel.basicNack(tag, false, true);
        }

    }


    private AddPointsRecordEvent convertTo(PointsRewardDto dto){
        AddPointsRecordEvent event = new AddPointsRecordEvent();
        event.setPoints(dto.getPoints())
                .setType(dto.getType())
                .setUserId(dto.getUserId())
                .setLocalDateTime(dto.getLocalDateTime());
        return event;
    }
}
