package org.hzz.learning.domain.event;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hzz.ddd.core.domain.shared.event.base.BaseDomainEvent;
import org.hzz.learning.domain.handler.ReplyLikedEventHandler;

/**
 * {@link ReplyLikedEventHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ReplyLikedEvent extends BaseDomainEvent {
    Long bizId;
    Long likedTimes;
}
