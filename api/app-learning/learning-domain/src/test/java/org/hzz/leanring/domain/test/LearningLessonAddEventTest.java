package org.hzz.leanring.domain.test;

import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.hzz.learning.domain.event.LearningLessonAddEvent;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Slf4j
public class LearningLessonAddEventTest {
    public static void main(String[] args) throws InterruptedException {
        LearningLessonAddEvent event = LearningLessonAddEvent.eventOf(1l, 2l,
                List.of(1l, 2l, 3l),
                LocalDateTime.now());
        String json = JSON.toJSONString(event);
        log.info(json);
        Thread.sleep(1000);
        LearningLessonAddEvent learningLessonAddEvent = JSON.parseObject(json, LearningLessonAddEvent.class);
        // 验证Instant now不被反序列化
        log.info("{} at {}",event.toString(),event.occurredOn());
        log.info("{} at {}",learningLessonAddEvent.toString(),learningLessonAddEvent.occurredOn());
        System.out.println(event.equals(learningLessonAddEvent)); // true
    }
}


