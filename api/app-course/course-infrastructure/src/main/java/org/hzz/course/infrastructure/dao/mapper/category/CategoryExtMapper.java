package org.hzz.course.infrastructure.dao.mapper.category;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hzz.core.enums.delete.Deleted;
import org.hzz.course.infrastructure.dao.model.category.Category;

import java.util.List;

/**
 * 扩展功能
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Mapper
public interface CategoryExtMapper {
    List<Category> selectAll();

    /**
     * 查询逻辑未删除或删除的记录
     * @param deleted {@link Deleted}
     * @return 列表
     */
    List<Category> selectAllByFilterDeleted(@Param("deleted") Deleted deleted);
}
