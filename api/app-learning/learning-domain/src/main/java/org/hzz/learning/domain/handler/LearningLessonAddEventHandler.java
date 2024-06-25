package org.hzz.learning.domain.handler;

import lombok.extern.slf4j.Slf4j;
import org.hzz.learning.domain.event.LearningLessonAddEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 处理添加课程事件
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Component
@Slf4j
public class LearningLessonAddEventHandler {

    @EventListener
    public void handleLearningLessonAddEvent(LearningLessonAddEvent event){
        log.info("准备处理: {}",event);

        // todo 提交ack
    }
}
