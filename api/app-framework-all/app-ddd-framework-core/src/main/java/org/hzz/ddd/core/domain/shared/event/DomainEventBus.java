package org.hzz.ddd.core.domain.shared.event;

/**
 * 领域事件总线
 * 子类实现用于发布领域事件
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
public interface DomainEventBus<E extends DomainEvent> {

    /**
     * 发布领域事件
     * @param event
     */
    void publishDomainEvent(E event);
}
