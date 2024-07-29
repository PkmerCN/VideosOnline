package org.hzz.points.trigger;

import org.hzz.points.trigger.mq.rabbitmq.config.RabbitMqConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.stream.Stream;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
//@SpringBootApplication(scanBasePackages = "org.hzz.points.trigger")
public class PointsRabbitApp {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(PointsRabbitApp.class);
        ConfigurableApplicationContext applicationContext = application.run(args);

        String[] beanNamesForQueue = applicationContext.getBeanNamesForType(Queue.class);
        Stream.of(beanNamesForQueue).forEach(System.out::println);
        System.out.println("=======================================");
        String[] beanNamesForBinding = applicationContext.getBeanNamesForType(Binding.class);
        Stream.of(beanNamesForBinding).forEach(System.out::println);
        System.out.println("=======================================");
        String[] beanNamesForWriteReplyConfig = applicationContext.getBeanNamesForType(RabbitMqConfig.WriteReplyConfig.class);
        Stream.of(beanNamesForWriteReplyConfig).forEach(System.out::println);
    }
}
