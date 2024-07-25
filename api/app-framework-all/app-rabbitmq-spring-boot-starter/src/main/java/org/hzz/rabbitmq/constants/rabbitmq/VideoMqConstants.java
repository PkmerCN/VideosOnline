package org.hzz.rabbitmq.constants.rabbitmq;

/**
 * 统一维护
 * import static org.hzz.rabbitmq.constants.rabbitmq.VideoMqConstants.Queue.*;
 * import static org.hzz.rabbitmq.constants.rabbitmq.VideoMqConstants.Key.*;
 * import static org.hzz.rabbitmq.constants.rabbitmq.VideoMqConstants.Exchange.*;
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
public interface VideoMqConstants {
    interface Exchange{
        String LEARNING_EXCHANGE = "learning.direct";
        String ORDER_EXCHANGE = "order.direct";
        /** 点赞记录交换机 */
        String LIKE_RECORD_EXCHANGE = "like.record.topic";
    }
    interface Queue{
        String LEARNING_LESSON_PAY_QUEUE = "learning.lesson.pay.queue";
    }
    interface Key{
        String LESSON_PAY_KEY = "lesson.pay";

        /** 点赞的RoutingKey */
        String LIKED_TIMES_KEY_TEMPLATE = "{}.times.changed";
    }
}
