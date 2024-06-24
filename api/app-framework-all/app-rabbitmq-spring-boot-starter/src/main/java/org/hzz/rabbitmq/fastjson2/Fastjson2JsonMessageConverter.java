package org.hzz.rabbitmq.fastjson2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.support.converter.AbstractMessageConverter;
import org.springframework.amqp.support.converter.MessageConversionException;


/**
 * 使用Fastjson2
 * 将Java对象转换为json
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/23
 */
public class Fastjson2JsonMessageConverter extends AbstractMessageConverter {
    private final FastJsonConfig fastJsonConfig;

    public Fastjson2JsonMessageConverter() {
        this.fastJsonConfig = new FastJsonConfig();
    }
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
     * 将消息取出来，交给后面的MappingFastJsonMessageConverter来进行反序列化
     * @param message the message to convert
     * @return
     * @throws MessageConversionException
     */
    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        return message.getBody();
    }
}
