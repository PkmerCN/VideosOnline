package org.hzz.rabbitmq.fastjson2;

//import com.alibaba.fastjson2.support.spring6.messaging.converter.MappingFastJsonMessageConverter;
import com.alibaba.fastjson2.support.spring.messaging.converter.MappingFastJsonMessageConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * 配置反序列化,方便使用@payload
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
@Configuration
@Slf4j
@EnableRabbit
public class Fastjson2RabbitListenerConfigurer implements RabbitListenerConfigurer {
    /**
     * 要配置成一个bean,覆盖掉默认的DefaultMessageHandlerMethodFactory
     * @return
     */
    @Bean
    public DefaultMessageHandlerMethodFactory defaultMessageHandlerMethodFactory(){
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        // 这里的转换器设置实现了 通过 @Payload 注解 自动反序列化message body
        factory.setMessageConverter(mappingFastJsonMessageConverter());
        return factory;
    }

    @Bean
    public MessageConverter mappingFastJsonMessageConverter(){
        return new MappingFastJsonMessageConverter();
    }
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        rabbitListenerEndpointRegistrar.setMessageHandlerMethodFactory(defaultMessageHandlerMethodFactory());
    }
}
