package org.hzz.ddd.core.domain.shared.event;

import org.hzz.ddd.core.domain.shared.event.base.BaseDomainEvent;

import java.time.Instant;

/**
 * 领域事件
 * 通过定义一个通用的DomainEvent接口，可以确保所有领域事件具有一致的结构和行为。
 * 这不仅有助于代码的组织和维护，还可以使事件处理更加通用和灵活。
 * 每个具体的事件类只需实现该接口，并根据需要添加具体的业务逻辑。
 * 领域事件基础类,{@link BaseDomainEvent}
 * 具体事件有具体的{@link DomainEventHandler} 领域事件处理器
 *
 * 发布事件通过
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public interface DomainEvent {
    /**
     * 事件发生的时间
     * @return 时间发生时间
     */
    Instant occurredOn();
}
