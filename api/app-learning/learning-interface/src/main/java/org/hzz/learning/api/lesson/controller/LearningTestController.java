package org.hzz.learning.api.lesson.controller;

import com.alibaba.fastjson2.JSON;
import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.learning.api.lesson.LearningTestApi;
import org.hzz.learning.domain.event.LearningLessonAddEvent;
import org.hzz.learning.infrastructure.mq.rabbitmq.model.TestData;
import org.hzz.rabbitmq.core.RabbitMQHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static org.hzz.learning.infrastructure.mq.rabbitmq.constants.RabbitmqConstants.RoutingKey.LEARNING_TEST_KEY;
import static org.hzz.rabbitmq.constants.rabbitmq.VideoMqConstants.Key.*;
import static org.hzz.rabbitmq.constants.rabbitmq.VideoMqConstants.Exchange.*;
/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
@RestController
public class LearningTestController extends BaseController implements LearningTestApi {
    @Setter(onMethod_ = @Autowired)
    private RabbitMQHelper rabbitMQHelper;

    @Override
    public Result<String> sendMsg(String msg) {
        TestData testData = new TestData();
        testData.setMsg(msg);
        rabbitMQHelper.send(
                LEARNING_EXCHANGE,
                LEARNING_TEST_KEY,
                testData);
        logger.info("发送成功");
        return success(String.format("发送 %s success", JSON.toJSON(testData)));
    }

    @Override
    public Result<LearningLessonAddEvent> sendPayLesson(Long userId) {
        LearningLessonAddEvent event = LearningLessonAddEvent.eventOf(1L, userId,
                List.of(1L, 2L, 3L),
                LocalDateTime.now());

        rabbitMQHelper.send(ORDER_EXCHANGE,LESSON_PAY_KEY,event);
        logger.info("发送成功");
        return success(event);
    }
}
