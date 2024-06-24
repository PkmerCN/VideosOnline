package org.hzz.learning.domain.event;

import lombok.*;
import org.hzz.ddd.core.domain.shared.event.base.BaseDomainEvent;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 添加课程事件
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Data
@Value(staticConstructor = "eventOf")
@EqualsAndHashCode(callSuper = false)
public class LearningLessonAddEvent extends BaseDomainEvent{
    /**
     * 订单ID
     */
    private Long orderId;
    /**
     * 下单用户ID
     */
    private Long userId;

    /**
     * 下单的课程IDs
     */
    private List<Long> couseIds;

    /**
     * 订单完成时间
     */
    private LocalDateTime finishTime;
}


