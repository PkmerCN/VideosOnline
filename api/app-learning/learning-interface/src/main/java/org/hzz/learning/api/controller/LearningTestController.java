package org.hzz.learning.api.controller;

import com.alibaba.fastjson2.JSON;
import org.hzz.core.controller.BaseController;
import org.hzz.learning.api.LearningTestApi;
import org.hzz.learning.infrastructure.mq.rabbitmq.model.TestData;
import org.hzz.rabbitmq.core.RabbitMQHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import static org.hzz.learning.infrastructure.mq.rabbitmq.constants.RabbitmqConstants.Exchange.*;
import static org.hzz.learning.infrastructure.mq.rabbitmq.constants.RabbitmqConstants.RoutingKey.*;
/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/24
 */
@RestController
public class LearningTestController extends BaseController implements LearningTestApi {
    @Autowired
    private RabbitMQHelper rabbitMQHelper;

    public String sendMsg(String msg) {
        TestData testData = new TestData();
        testData.setMsg(msg);
        rabbitMQHelper.send(
                LEARNING_EXCHANGE,
                LEARNING_TEST_KEY,
                testData);
        logger.info("发送成功");
        return String.format("发送 %s success", JSON.toJSON(testData));
    }
}
