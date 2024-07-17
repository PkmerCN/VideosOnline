package org.hzz.core.repository.withmapper;

import org.hzz.common.collection.CollUtil;
import org.hzz.core.mapper.PageMapper;
import org.hzz.core.page.query.PageQuery;
import org.hzz.core.page.PageResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 封装通用分页逻辑
 * @param <P>  代表mapper
 * @param <T> 代表返回的类型
 * @param <C> 代表Converter
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public abstract class PageBaseRepository<P extends PageMapper<T>,T,C> extends BaseRepository<P,C> {

    public PageResponse<T> pageQuery(PageQuery pageQuery){
        // LIMIT #{limit} OFFSET #{offset}
        // 查询的记录数据
        final Integer limit = pageQuery.getPageSize();
        // 需要跳过的记录数据
        final Integer offset = (pageQuery.getPageNo() - 1) * pageQuery.getPageSize();

        // 构建排序
        String orderByClause = null;

        if(CollUtil.isNotEmpty(pageQuery.getSortOrders())){
            orderByClause = pageQuery.getSortOrders().stream()
                    .map(sortOrder -> String.format("%s %s",sortOrder.getField(),(sortOrder.getIsAsc() ? "ASC":"DESC")))
                    .collect(Collectors.joining(","));
            logger.info("orderByClause = {}",orderByClause);
        }

        int total = mapper.countRecords(pageQuery.getFilters());
        int totalPages = (int) Math.ceil((double) total / pageQuery.getPageSize());
        // todo 有sql注入的风险
        List<T> list = mapper.pageSelect(offset, limit, orderByClause,pageQuery.getFilters());

        return PageResponse.<T>builder().totalPages(totalPages)
                .currentPageNo(pageQuery.getPageNo())
                .total(total)
                .list(list).build();
    }

}
