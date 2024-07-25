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
        /** 问答点赞队列 */
        String AQ_LIKED_TIMES_QUEUE = "qa.liked.times.queue";
    }
    interface Key{
        String LESSON_PAY_KEY = "lesson.pay";

        /** 点赞的RoutingKey 模版 */
        String LIKED_TIMES_KEY_TEMPLATE = "{}.times.changed";
        /** 问答系统点赞 */
        String QA_LIKED_TIMES_KEY = "QA.times.changed";
    }
}
