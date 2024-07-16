package org.hzz.core.repository.nomapper;

import lombok.Setter;
import org.hzz.core.base.AppBase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @param <M> 对应的mybatis Mapper
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
public abstract class BaseRepository<M> extends AppBase {
    @Setter(onMethod_ = @Autowired)
    protected M mapper;
}
