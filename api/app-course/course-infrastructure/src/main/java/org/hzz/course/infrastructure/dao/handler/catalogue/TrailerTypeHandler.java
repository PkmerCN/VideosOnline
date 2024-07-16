package org.hzz.course.infrastructure.dao.handler.catalogue;

import org.hzz.core.handler.ByteTypeHandler;
import org.hzz.course.types.enums.catalogue.TrailerType;

/**
 * 是否支持试看枚举处理 {@link TrailerType}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
public class TrailerTypeHandler extends ByteTypeHandler<TrailerType> {
    @Override
    protected TrailerType fromValue(Byte value) {
        return TrailerType.fromValue(value);
    }
}
