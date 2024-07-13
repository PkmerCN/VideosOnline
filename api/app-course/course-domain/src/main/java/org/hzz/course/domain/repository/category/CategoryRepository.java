package org.hzz.course.domain.repository.category;

import org.hzz.core.enums.delete.Deleted;
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

    /**
     * 查询所有的分类
     */
    List<CategoryEntity> selectAll();

    /**
     * 查询可使用的分类
     * @param deleted {@link Deleted} 是否逻辑删除
     * @return 列表
     */
    List<CategoryEntity> selectEnableAll(Deleted deleted);
}
