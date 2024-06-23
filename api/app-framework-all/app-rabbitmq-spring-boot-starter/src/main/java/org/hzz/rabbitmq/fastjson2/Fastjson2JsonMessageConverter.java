package org.hzz.rabbitmq.fastjson2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;

import java.lang.reflect.Type;

/**
 * 使用Fastjson2
 * 将Java对象转换为json
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/23
 */
public class Fastjson2JsonMessageConverter extends AbstractMessageConverter {
    private static final Type type = new TypeReference<Object>(){}.getType();

    /**
     * 将Java对象转换为消息
     * @param o the payload.
     * @param messageProperties the message properties (headers).
     * @return
     */
    @Override
    protected Message createMessage(Object o, MessageProperties messageProperties) {
        byte[] bytes = JSON.toJSONBytes(o);
        messageProperties.setContentType("application/json");
        messageProperties.setContentEncoding("UTF-8");
        messageProperties.setContentLength(bytes.length);
        return new Message(bytes, messageProperties);
    }

    /**
     * 将消息转换为Java对象
     * @param message the message to convert
     * @return
     * @throws MessageConversionException
     */
    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        byte[] body = message.getBody();
        return JSON.parseObject(body, type);
    }
}
