package org.hzz.ddd.core.domain.shared.event;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
public interface DomainEventBus {

    void publishDomainEvent(DomainEvent domainEvent);
}
