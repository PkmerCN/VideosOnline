package org.hzz.points.infrastructure.dao.handler;

import org.hzz.core.handler.ByteTypeHandler;
import org.hzz.points.types.enums.PointsType;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/29
 */
public class PointsTypeHandler extends ByteTypeHandler<PointsType> {
    @Override
    protected PointsType fromValue(Byte value) {
        return PointsType.fromValue(value);
    }
}
