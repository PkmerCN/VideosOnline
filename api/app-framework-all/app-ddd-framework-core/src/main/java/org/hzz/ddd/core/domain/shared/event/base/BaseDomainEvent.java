package org.hzz.ddd.core.domain.shared.event.base;

import com.alibaba.fastjson2.annotation.JSONField;
import org.hzz.ddd.core.domain.shared.event.DomainEvent;

import java.time.Instant;

/**
 * 领域事件产生时间
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/25
 */
public class BaseDomainEvent implements DomainEvent {
    @JSONField(serialize = false,deserialize = false)
    private final Instant now;
    public BaseDomainEvent(){
        this.now = Instant.now();
    }
    @Override
    public Instant occurredOn() {
        return now;
    }
}
