package org.hzz.core.repository;

import org.hzz.core.base.AppBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public abstract class BaseRepository<M,C> extends AppBase {
    @Autowired
    protected M mapper;

    @Autowired
    protected C converter;
}
