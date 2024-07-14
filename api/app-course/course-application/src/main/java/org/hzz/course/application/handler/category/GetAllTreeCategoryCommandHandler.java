package org.hzz.course.application.handler.category;

import lombok.Setter;
import org.hzz.common.tree.BaseConverter;
import org.hzz.common.tree.TreeDataUtils;
import org.hzz.course.application.command.category.GetAllTreeCategoryCommand;
import org.hzz.course.application.dto.CategoryTreeDto;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.domain.service.category.CategoryDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 获取所有的分类以树形结构返回
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
@Component
public class GetAllTreeCategoryCommandHandler
        extends CategoryExecuteStrategy<GetAllTreeCategoryCommand, List<CategoryTreeDto>> {

    @Setter(onMethod_ = @Autowired)
    private CategoryDomainService categoryDomainService;

    @Override
    public String mark() {
        return GetAllTreeCategoryCommand.MARK;
    }

    @Override
    public List<CategoryTreeDto> executeWithResp(GetAllTreeCategoryCommand command) {

        List<CategoryEntity> categories =  getCategory(command);

        // 转树形结构
        List<CategoryTreeDto> categoryTreeDtos = TreeDataUtils.parseToTree(
                categories,
                CategoryConvert.INSTANCE,
                new CategoryDataProcess());
        if(categoryTreeDtos != null){
            logger.info("一共有{}个一级分类",categoryTreeDtos.size());
        }
        return categoryTreeDtos;
    }

    /**
     * 获取分类信息
     */
    private List<CategoryEntity> getCategory(GetAllTreeCategoryCommand command) {
        List<CategoryEntity> results;
        if(command.getIsAdmin()){
            // 获取所有分类
            results = categoryDomainService.getAllCategoryEntities();
        }else{
            // 只能获取可用的分类，禁止的分类不会获取到
            results = categoryDomainService.getAvailableCategoryEntities();
        }
        return results;
    }


    /**
     * 转换
     */
    @Mapper
    interface CategoryConvert extends BaseConverter<CategoryTreeDto,CategoryEntity>{
        CategoryConvert INSTANCE = Mappers.getMapper(CategoryConvert.class);
    }

    /**
     * 用于{@link TreeDataUtils}进行树形转换
     */
    static class CategoryDataProcess implements TreeDataUtils.DataProcessor<CategoryTreeDto,CategoryEntity>{

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

}


