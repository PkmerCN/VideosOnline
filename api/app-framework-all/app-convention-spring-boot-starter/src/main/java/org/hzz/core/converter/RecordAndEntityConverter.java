package org.hzz.core.converter;

import org.hzz.core.page.PageResponse;
import java.util.List;

/**
 * 用于Mapstruct的具体转换继承
 * 使用与domain与infrastructure层进行转换
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

    /**
     * 分页转化
     */
    PageResponse<R> convertToRecordPage(PageResponse<E> pageResponse);

    /**
     * 分页转化
     */
    PageResponse<E> convertToEntityPage(PageResponse<R> pageResponse);
}
