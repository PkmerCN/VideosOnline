package org.hzz.course.api.category.controller;

import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.course.api.category.CategoryApi;
import org.hzz.course.types.resp.CategoryVo;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
@RestController
public class CategoryController extends BaseController implements CategoryApi {

    /**
     * {@inheritDoc}
     */
    @Override
    public Result<List<CategoryVo>> all(Boolean isAdmin) {
        logger.info("是否为admin管理员请求：{}",isAdmin);
        return null;
    }
}
