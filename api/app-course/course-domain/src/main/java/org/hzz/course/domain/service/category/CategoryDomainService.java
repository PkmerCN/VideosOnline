package org.hzz.course.domain.service.category;

import org.hzz.course.domain.entity.CategoryEntity;

import java.util.List;
import java.util.Set;

/**
 * 分类领域服务
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public interface CategoryDomainService {

    /**
     * 获取分类列表
     * @param ids 对应的分类id
     * @return List
     */
    List<CategoryEntity> getCategoryEntities(Set<Long> ids);
}
