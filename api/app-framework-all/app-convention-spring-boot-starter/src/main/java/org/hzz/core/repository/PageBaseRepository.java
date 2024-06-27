package org.hzz.core.repository;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.mapper.PageMapper;
import org.hzz.core.page.PageRequest;
import org.hzz.core.page.PageResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 封装通用分页逻辑
 * p 代表mapper
 * T 代表返回的类型
 * C 代表Converter
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public class PageBaseRepository<P extends PageMapper<T>,T,C> extends BaseRepository<P,C> {

    PageResponse<T> pageQuery(PageRequest pageRequest){
        // LIMIT #{limit} OFFSET #{offset}
        // 查询的记录数据
        final Integer limit = pageRequest.getPageSize();
        // 需要跳过的记录数据
        final Integer offset = (pageRequest.getPageNo() - 1) * pageRequest.getPageSize();

        // 构建排序
        String orderByClause = null;

        if(CollUtil.isNotEmpty(pageRequest.getSortOrders())){
            orderByClause = pageRequest.getSortOrders().stream()
                    .map(sortOrder -> String.format("%s %s",sortOrder.getField(),(sortOrder.getIsAsc() ? "ASC":"DESC")))
                    .collect(Collectors.joining(","));
            logger.info("orderByClause = {}",orderByClause);
        }

        int total = mapper.countRecords();
        int totalPages = (int) Math.ceil((double) total / pageRequest.getPageSize());

        List<T> list = mapper.pageSelect(offset, limit, orderByClause);

        return PageResponse.<T>builder().totalPages(totalPages)
                .currentPageNo(pageRequest.getPageNo())
                .total(total)
                .list(list).build();
    }
}
