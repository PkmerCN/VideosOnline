package org.hzz.core.repository;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.mapper.PageMapper;
import org.hzz.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
public class PageBaseRepository<P extends PageMapper<?>,C> extends BaseRepository<P,C> {

    void pageQuery(PageRequest pageRequest){
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

        mapper.selectEntities(offset,limit,orderByClause);
    }
}
