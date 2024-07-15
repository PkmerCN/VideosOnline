package org.hzz.course.application.handler.category;

import lombok.Setter;
import org.hzz.course.application.command.category.GetAllTreeCategoryCommand;
import org.hzz.course.cache.category.CategoryCache;
import org.hzz.course.types.dto.CategoryTreeDto;
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
    private CategoryCache categoryCache;

    @Override
    public String mark() {
        return GetAllTreeCategoryCommand.MARK;
    }

    @Override
    public List<CategoryTreeDto> executeWithResp(GetAllTreeCategoryCommand command) {
        // 从caffeine缓存中获取数据
        if(command.getIsAdmin()){
            // 获取所有分类
            return categoryCache.getAllTreeCategory();
        }else{
            // 只能获取可用的分类，禁止的分类不会获取到
            return categoryCache.getAvailableTreeCategory();
        }
    }
}


