package org.hzz.course.cache.category;

import org.hzz.common.tree.TreeDataUtils;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.types.dto.CategoryTreeDto;

import java.util.List;

/**
 * 用于{@link TreeDataUtils}进行树形转换
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/15
 */
class CategoryDataProcess implements TreeDataUtils.DataProcessor<CategoryTreeDto, CategoryEntity>{

    @Override
    public Object getParentKey(CategoryEntity categoryEntity) {
        return categoryEntity.getParentId();
    }

    @Override
    public Object getKey(CategoryEntity categoryEntity) {
        return categoryEntity.getId();
    }

    @Override
    public Object getRootKey() {
        return 0L;
    }

    @Override
    public List<CategoryTreeDto> getChild(CategoryTreeDto categoryTreeDto) {
        return categoryTreeDto.getChildren();
    }

    @Override
    public void setChild(CategoryTreeDto parent, List<CategoryTreeDto> child) {
        parent.setChildren(child);
    }

    @Override
    public void addChildElement(CategoryTreeDto parent, CategoryTreeDto childElement) {
        parent.getChildren().add(childElement);
    }

    @Override
    public CategoryTreeDto createNewObject() {
        return new CategoryTreeDto();
    }
}