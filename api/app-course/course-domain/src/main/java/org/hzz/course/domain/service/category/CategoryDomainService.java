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

    /**
     * 获取系统中所有的分类
     * @return 包括可用和禁用的分类
     */
    List<CategoryEntity> getAllCategoryEntities();

    /**
     * 获取系统中所有可用的分类
     * @return 可用的分类
     */
    List<CategoryEntity> getAvailableCategoryEntities();

}
