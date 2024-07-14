package org.hzz.course.application.handler.category;

import lombok.Setter;
import org.hzz.course.application.command.category.GetAllTreeCategoryCommand;
import org.hzz.course.domain.entity.CategoryEntity;
import org.hzz.course.domain.service.category.CategoryDomainService;
import org.hzz.course.types.resp.CategoryVo;
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
        extends CategoryExecuteStrategy<GetAllTreeCategoryCommand, List<CategoryVo>> {

    @Setter(onMethod_ = @Autowired)
    private CategoryDomainService categoryDomainService;

    @Override
    public String mark() {
        return GetAllTreeCategoryCommand.MARK;
    }

    @Override
    public List<CategoryVo> executeWithResp(GetAllTreeCategoryCommand command) {

        List<CategoryEntity> categories =  getCategory(command);

        // 转树形结构

        return null;
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


}


