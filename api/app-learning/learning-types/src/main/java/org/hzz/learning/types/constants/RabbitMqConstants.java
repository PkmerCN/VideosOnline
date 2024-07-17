package org.hzz.learning.types.constants;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
public interface RabbitMqConstants {
    interface Exchange{
        String LEARNING_EXCHANGE = "learning.direct";
    }
    interface Queue{
        String LEARNING_LESSON_PAY_QUEUE = "learning.lesson.pay.queue";
    }
    interface Key{
        String LESSON_PAY_KEY = "lesson.pay";
    }
}
