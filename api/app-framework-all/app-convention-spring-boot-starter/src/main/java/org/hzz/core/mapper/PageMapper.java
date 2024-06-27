package org.hzz.core.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public interface PageMapper<T> {
    List<T> pageSelect(@Param("offset") Integer offset,
                           @Param("limit") Integer limit,
                           @Param("orderByClause") String orderByClause);

    int countRecords();
}
