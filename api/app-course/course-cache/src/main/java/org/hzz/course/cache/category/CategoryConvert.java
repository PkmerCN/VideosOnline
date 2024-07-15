package org.hzz.course.cache.category;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */

import org.hzz.common.tree.BaseConverter;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.types.dto.CategoryTreeDto;
import org.mapstruct.Mapper;

/**
 * 转换
 */
@Mapper(componentModel = "spring")
public interface CategoryConvert extends BaseConverter<CategoryTreeDto, CategoryEntity> {
}
