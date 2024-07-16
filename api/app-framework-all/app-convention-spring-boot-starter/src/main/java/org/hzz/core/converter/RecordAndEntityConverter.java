package org.hzz.core.converter;

import java.util.List;

/**
 * 用于Mapstruct的具体转换继承
 * @param <R> record 记（mybatis对应对应表记录）
 * @param <E> entity 实体
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/17
 */
public interface RecordAndEntityConverter<R,E> {

    E toEntity(R r);

    List<E> toEntities(List<R> list);
    R toRecord(E e);
    List<E> toRecords(List<E> list);
}
