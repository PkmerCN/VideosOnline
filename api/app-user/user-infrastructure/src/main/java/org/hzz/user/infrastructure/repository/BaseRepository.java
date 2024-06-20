package org.hzz.user.infrastructure.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
@Repository
public abstract class BaseRepository<T,M> {
   @Autowired
    protected T mapper;

   @Autowired
    protected M converter;
}
