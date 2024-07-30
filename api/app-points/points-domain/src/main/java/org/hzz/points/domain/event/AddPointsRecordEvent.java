package org.hzz.points.domain.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.event.base.BaseDomainEvent;
import org.hzz.points.domain.handler.AddPointsRecordEventHandler;
import org.hzz.points.types.enums.PointsType;

import java.time.LocalDateTime;

/**
 * 处理器{@link AddPointsRecordEventHandler}
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
    PointsType type;
    LocalDateTime localDateTime;
}
