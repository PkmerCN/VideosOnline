package org.hzz.points.domain.aggregate;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.AggregateRoot;
import org.hzz.points.domain.entity.PointsBoardEntity;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
@Data
public class PointsBoardAggregate implements AggregateRoot {
    private PointsBoardEntity pointsBoardEntity;
    private List<PointsBoardEntity> entityList;
}
