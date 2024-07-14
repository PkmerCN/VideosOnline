package org.hzz.course.api.category;

import io.swagger.v3.oas.annotations.Operation;
import org.hzz.core.result.Result;
import org.hzz.course.types.resp.CategoryTreeVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
@RequestMapping("/categorys")
public interface CategoryApi {

    /**
     * {@code isAdmin} 是否为管理员查询
     * @param isAdmin 是否为管理员
     */
    @Operation(description = "获取所有的课程分类信息，只包含id,名称，课程分类关系")
    @GetMapping("/all")
    Result<List<CategoryTreeVo>> all(
            @RequestParam(value = "admin",required = false,defaultValue = "false")
            Boolean isAdmin
    );

    @Operation(description = "是否禁用目录")
    @GetMapping("/{id}")
    Result<String> updateDeleted(
            @RequestParam(value = "delete",required = false,defaultValue = "false")
            Boolean isDelete,
            @PathVariable Long id
    );
}
