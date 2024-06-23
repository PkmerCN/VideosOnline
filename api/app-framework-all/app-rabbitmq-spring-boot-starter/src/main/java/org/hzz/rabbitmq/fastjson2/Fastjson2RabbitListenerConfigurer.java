package org.hzz.rabbitmq.fastjson2;

import com.alibaba.fastjson2.support.spring6.messaging.converter.MappingFastJsonMessageConverter;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * 配置反序列化,方便使用@payload
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
@Configuration
public class Fastjson2RabbitListenerConfigurer implements RabbitListenerConfigurer {

    public DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory(){
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        // 这里的转换器设置实现了 通过 @Payload 注解 自动反序列化message body
        factory.setMessageConverter(new MappingFastJsonMessageConverter());
        return factory;
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(defaultMessageHandlerMethodFactory());
    }
}
