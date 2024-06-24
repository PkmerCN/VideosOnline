package org.hzz.rabbitmq.fastjson2;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
     * 在这里不能返回一个JSONObject
     * @param message the message to convert
     * @return byte[]或者是一个string
     * @throws MessageConversionException
     */
    @Override
    public Object fromMessage(Message message) throws MessageConversionException {
        /**
         * 错误写法
         *         byte[] body = message.getBody();
         *         return JSON.parseObject(body,Object.class);
         */

        /**
         * 或者直接返回byte[]
         * return message.getBody();
         */
        // 最好写成json string的形式，方便兼容@RabbitHandler
        String payload = JSON.toJSONString(JSON.parseObject(message.getBody(),Object.class));
        log.info("payload = {}",payload);
        return payload;
    }
}
