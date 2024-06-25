package org.hzz.learning.trigger.mq.rabbitmq.constants;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
public interface MQConstants {
    interface Exchange{
        // todo 抽离到订单的
        String LEARNING_EXCHANGE = "order.direct";
    }
    interface Queue{
        String LEARNING_LESSON_PAY_QUEUE = "learning.lesson.pay.queue";
    }
    interface Key{
        String LESSON_PAY_KEY = "lesson.pay";
    }
}
