package org.hzz.course.infrastructure.dao.handler.category;

import org.hzz.core.handler.IntTypeHandler;
import org.hzz.course.types.enums.catagory.CategoryLevel;

/**
 * mybatis处理{@link CategoryLevel }枚举类型
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
public class CategoryLevelHandler extends IntTypeHandler<CategoryLevel> {

    @Override
    protected CategoryLevel fromValue(Integer value) {
        return CategoryLevel.fromValue(value);
    }
}
