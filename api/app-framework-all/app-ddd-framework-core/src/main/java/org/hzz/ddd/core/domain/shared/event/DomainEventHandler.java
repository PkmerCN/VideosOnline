package org.hzz.ddd.core.domain.shared.event;

import org.springframework.context.event.EventListener;

/**
 * 领域事件处理器
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public interface DomainEventHandler<T extends DomainEvent> {
    @EventListener
    void listen(T event);
}
