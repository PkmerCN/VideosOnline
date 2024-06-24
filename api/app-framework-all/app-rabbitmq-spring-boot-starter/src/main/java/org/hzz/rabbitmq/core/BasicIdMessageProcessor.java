package org.hzz.rabbitmq.core;

import lombok.extern.slf4j.Slf4j;
import org.hzz.rabbitmq.util.UUIDHelper;
import org.slf4j.MDC;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

import java.util.UUID;

import static org.hzz.rabbitmq.constants.Constant.*;

/**
 * rabbitmq发送消息之前和接受消息之后，设置requestId
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/23
 */
@Slf4j
public class BasicIdMessageProcessor implements MessagePostProcessor {
    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        String requestId = MDC.get(REQUEST_ID_HEADER);
        if(requestId == null){
            log.info("requestId为空，生成requestId");
            requestId = UUIDHelper.generateUUID();
        }
        log.info("requestId = {}",requestId);
        message.getMessageProperties().setHeader(REQUEST_ID_HEADER,requestId);
        message.getMessageProperties().setMessageId(requestId);
        return message;
    }
}
