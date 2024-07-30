package org.hzz.ddd.core.domain.shared.event.annotations;

import org.hzz.ddd.core.domain.shared.event.DomainEventBusImpl;
import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * 使用我们自己开发的领域事件发布器
 * // @Autowired
 * // @DomainEvent
 * // private DomainEventBus domainEventbus;
 * 注入的bean就是{@link DomainEventBusImpl}
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD ,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Qualifier
public @interface DDDBus {
}
