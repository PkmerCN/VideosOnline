package org.hzz.common.tree;

import java.util.List;

/**
 * MapStruct的基础类
 * @param <T> 原始数据
 * @param <R> 目标数据
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public interface BaseConverter<R,T> {

    List<R> covertToList(List<T> t);
    R convert(T t);
}