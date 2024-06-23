package org.hzz.rabbitmq.config;

import lombok.extern.slf4j.Slf4j;
import org.hzz.rabbitmq.core.RabbitMQHelper;
import org.hzz.rabbitmq.fastjson2.Fastjson2JsonMessageConverter;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/23
 */
@Slf4j
@Configuration
public class AppRabbitAutoConfig {

    public AppRabbitAutoConfig(){
        log.info("检测到AppRabbitAutoConfig");
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter converter){
        log.info("正在配置rabbitmq: message converter = {}",converter);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter);
        rabbitTemplate.setReplyTimeout(500);
        return rabbitTemplate;
    }

    @Bean
    @ConditionalOnBean(RabbitTemplate.class)
    @ConditionalOnMissingBean
    public RabbitMQHelper rabbitMQHelper(RabbitTemplate rabbitTemplate){
        log.info("自动配置RabbitMQHelper");
        return new RabbitMQHelper(rabbitTemplate);
    }

    @Bean
    public MessageConverter fastjson2JsonMessageConverter(){
        return new Fastjson2JsonMessageConverter();
    }
}
