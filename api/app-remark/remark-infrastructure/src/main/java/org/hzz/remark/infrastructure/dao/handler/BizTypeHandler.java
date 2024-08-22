package org.hzz.remark.infrastructure.dao.handler;

import io.gitee.pkmer.convention.handler.StringTypeHandler;
import org.hzz.remark.types.BizType;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
public class BizTypeHandler extends StringTypeHandler<BizType> {
    @Override
    protected BizType fromValue(String value) {
        return BizType.fromValue(value);
    }
}
