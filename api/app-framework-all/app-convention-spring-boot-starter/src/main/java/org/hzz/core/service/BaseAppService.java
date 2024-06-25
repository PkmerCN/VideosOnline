package org.hzz.core.service;

import lombok.Setter;
import org.hzz.core.base.AppBase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public abstract class BaseAppService<R> extends AppBase {
    @Setter(onMethod_ = @Autowired)
    protected R repository;
}
