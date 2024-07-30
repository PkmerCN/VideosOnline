package org.hzz.points.domain.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.event.base.BaseDomainEvent;

/**
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AddPointsRecordEvent extends BaseDomainEvent {
    Long userId;
    Integer points;
}
