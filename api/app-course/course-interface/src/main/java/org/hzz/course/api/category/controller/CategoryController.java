package org.hzz.course.api.category.controller;

import lombok.Setter;
import org.hzz.common.tree.BaseConverter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.course.api.category.CategoryApi;
import org.hzz.course.application.command.category.GetAllTreeCategoryCommand;
import org.hzz.course.application.dto.CategoryTreeDto;
import org.hzz.course.application.service.category.CategoryCmdService;
import org.hzz.course.types.resp.CategoryTreeVo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
@RestController
public class CategoryController extends BaseController implements CategoryApi {

    @Setter(onMethod_ = @Autowired)
    private CategoryCmdService categoryCmdService;

    /**
     * {@inheritDoc}
     */
    @Override
    public Result<List<CategoryTreeVo>> all(Boolean isAdmin) {
        logger.info("是否为admin管理员请求：{}",isAdmin);
        GetAllTreeCategoryCommand cmd = GetAllTreeCategoryCommand.commandOf(isAdmin);
        List<CategoryTreeDto> categoryTreeDtos = categoryCmdService.<List<CategoryTreeDto>>handleCommandWithResult(cmd);

        List<CategoryTreeVo> categoryTreeVos = CategoryTreeVoConvert.INSTANCE.covertToList(categoryTreeDtos);

        return success(categoryTreeVos);
    }


    @Mapper
    interface CategoryTreeVoConvert extends BaseConverter<CategoryTreeVo,CategoryTreeDto> {
        CategoryTreeVoConvert INSTANCE = Mappers.getMapper(CategoryTreeVoConvert.class);
    }
}
