package org.hzz.ddd.core.domain.shared;

/**
 * 创建复杂对象
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public interface Factory<T> {
    default T create(){
        throw new UnsupportedOperationException("unsupported");
    }
}
