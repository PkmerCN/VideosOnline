package org.hzz.rabbitmq.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;

/**
 * 设置延迟时间
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/23
 */
@Slf4j
public class DelayedMessageProcessor extends BasicIdMessageProcessor{
    private final long delay;
    public DelayedMessageProcessor(long delay){
        this.delay = delay;
    }

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        // 1. 添加消息requestid
        super.postProcessMessage(message);

        // 2.添加延迟时间
        message.getMessageProperties().setHeader("x-delay",this.delay);
        return message;
    }
}
