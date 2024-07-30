package org.hzz.learning.infrastructure.event;

import org.hzz.ddd.core.domain.shared.event.DomainEvent;
import org.hzz.ddd.core.domain.shared.event.DomainEventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * Learning模块事件发布总线
 * 基于spring事件机制实现
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
@Component("learningEventPublisher")
public class LearningEventPublisher implements DomainEventBus, ApplicationEventPublisherAware {

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void publishDomainEvent(DomainEvent event) {
        eventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
