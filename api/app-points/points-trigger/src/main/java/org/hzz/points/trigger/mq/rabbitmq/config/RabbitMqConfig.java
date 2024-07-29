package org.hzz.points.trigger.mq.rabbitmq.config;

import org.hzz.rabbitmq.constants.rabbitmq.video.PointsMqConstants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 积分队列绑定关系
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
@Configuration
public class RabbitMqConfig {
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(PointsMqConstants.Exchange.POINTS_EXCHANGE);
    }

    /**
     * 写回答绑定配置
     */
    @Configuration
    public class WriteReplyConfig {
        @Bean(PointsMqConstants.Queue.WRITE_REPLY)
        public Queue queue() {
            return new Queue(PointsMqConstants.Queue.WRITE_REPLY, true);
        }

        @Bean
        public Binding writeReplybinding() {
            return BindingBuilder.bind(queue())
                    .to(exchange())
                    .with(PointsMqConstants.Key.WRITE_REPLY);
        }
    }


    /**
     * 签到绑定配置
     */
    @Configuration
    public class SignInConfig {
        @Bean(PointsMqConstants.Queue.SIGN_IN)
        public Queue queue() {
            return new Queue(PointsMqConstants.Queue.SIGN_IN, true);
        }

        @Bean
        public Binding signInbinding() {
            return BindingBuilder.bind(queue())
                    .to(exchange())
                    .with(PointsMqConstants.Key.SIGN_IN);
        }
    }

    /**
     * 学习绑定配置
     */
    @Configuration
    public class LearnSectionConfig {
        @Bean(PointsMqConstants.Queue.LEARN_SECTION)
        public Queue queue() {
            return new Queue(PointsMqConstants.Queue.LEARN_SECTION, true);
        }

        @Bean
        public Binding learnSectionbinding() {
            return BindingBuilder.bind(queue())
                    .to(exchange())
                    .with(PointsMqConstants.Key.LEARN_SECTION);
        }
    }

    /**
     * 写笔记绑定配置
     */
    @Configuration
    public class WriteNoteConfig {
        @Bean(PointsMqConstants.Queue.WRITE_NOTE)
        public Queue queue() {
            return new Queue(PointsMqConstants.Queue.WRITE_NOTE, true);
        }

        @Bean
        public Binding writeNotebinding() {
            return BindingBuilder.bind(queue())
                    .to(exchange())
                    .with(PointsMqConstants.Key.WRITE_NOTE);
        }
    }

    /**
     * 笔记被采集绑定配置
     */
    @Configuration
    public class NoteGatheredConfig {
        @Bean(PointsMqConstants.Queue.NOTE_GATHERED)
        public Queue queue() {
            return new Queue(PointsMqConstants.Queue.NOTE_GATHERED, true);
        }

        @Bean
        public Binding noteGatheredbinding() {
            return BindingBuilder.bind(queue())
                    .to(exchange())
                    .with(PointsMqConstants.Key.NOTE_GATHERED);
        }
    }

}
