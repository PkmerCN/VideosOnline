package org.hzz.ddd.core.domain.shared.event;

import lombok.extern.slf4j.Slf4j;
import org.hzz.ddd.core.domain.shared.event.annotations.DDDBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 领域发布事件实现类
 * 为了兼容自定义的领域发布器，为了使用这个我们默认定义的领域事件发布器，
 * // @Autowired
 * // @DomainEvent
 * // private DomainEventBus domainEventbus;
 * 注入的bean就是{@link DomainEventBusImpl}
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Component
@DDDBus
@Slf4j
public class DomainEventBusImpl implements DomainEventBus, ApplicationEventPublisherAware {
    private ApplicationEventPublisher eventPublisher;

    @Override
    public void publishDomainEvent(DomainEvent event) {
        log.info("发布领域事件： {} AT {}",event.getClass().getSimpleName(),event.occurredOn());
        eventPublisher.publishEvent(event);
    }

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }
}
