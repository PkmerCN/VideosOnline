package org.hzz.core.repository;

import lombok.Setter;
import org.hzz.core.base.AppBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public abstract class BaseRepository<M,C> extends AppBase {
    @Setter(onMethod_ = @Autowired)
    protected M mapper;

    @Setter(onMethod_ = @Autowired)
    protected C converter;
}
