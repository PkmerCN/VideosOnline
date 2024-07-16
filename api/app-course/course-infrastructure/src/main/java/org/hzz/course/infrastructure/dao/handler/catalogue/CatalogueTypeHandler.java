package org.hzz.course.infrastructure.dao.handler.catalogue;

import org.hzz.core.handler.ByteTypeHandler;
import org.hzz.course.types.enums.catalogue.CatalogueType;

/**
 * {@link CatalogueType}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
public class CatalogueTypeHandler extends ByteTypeHandler<CatalogueType> {
    @Override
    protected CatalogueType fromValue(Byte value) {
        return CatalogueType.fromValue(value);
    }
}
