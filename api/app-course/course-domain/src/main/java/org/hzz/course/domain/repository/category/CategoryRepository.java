package org.hzz.course.domain.repository.category;

import org.hzz.course.domain.entity.CategoryEntity;

import java.util.List;
import java.util.Set;

/**
 * 分类repository
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public interface CategoryRepository {

    /**
     * 根据分类id查询分类信息
     * @param ids 分类id集合
     * @return 分类信息
     */
    List<CategoryEntity> selectByIds(Set<Long> ids);
}
