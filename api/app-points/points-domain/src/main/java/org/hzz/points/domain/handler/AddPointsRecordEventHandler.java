package org.hzz.points.domain.handler;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.event.DomainEventHandler;
import org.hzz.points.domain.entity.PointsRecordEntity;
import org.hzz.points.domain.event.AddPointsRecordEvent;
import org.hzz.points.domain.service.points.PointsDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/30
 */
@Component
public class AddPointsRecordEventHandler implements DomainEventHandler<AddPointsRecordEvent> {

    @Setter(onMethod_ = @Autowired)
    private PointsDomainService pointsDomainService;

    @Override
    public void listen(AddPointsRecordEvent event) {

        PointsRecordEntity entity = new PointsRecordEntity();
        entity.setPoints(event.getPoints().byteValue())
                .setType(event.getType())
                .setUserId(event.getUserId())
                .setCreateTime(event.getLocalDateTime());

        pointsDomainService.addPoints(entity);

    }
}
