package org.hzz.course.types.dto;

import lombok.Data;
import org.hzz.course.types.enums.CategoryLevel;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/14
 */
@Data
public class CategoryTreeDto {
    // 课程分类id
    private Long id;

    // 分类名称
    private String name;

    // 父分类id，一级分类父id为0
    private Long parentId;

    // 分类级别，1,2,3：代表一级分类，二级分类，三级分类
    private CategoryLevel level;

    //    子分类
    List<CategoryTreeDto> children;
}
