package org.hzz.learning.infrastructure.mq.rabbitmq.constants;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
public interface RabbitmqConstants {
    interface Exchange{
       String LEARNING_EXCHANGE = "video.learning";
    }

    interface Queue{
        String LEARNING_TEST_QUEUE = "leanring.test";
    }

    interface RoutingKey{
        String LEARNING_TEST_KEY = "learning.test";
    }
}
