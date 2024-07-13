package org.hzz.course.domain.entity;

import lombok.Data;
import org.hzz.core.enums.delete.Deleted;
import org.hzz.course.types.enums.CategoryLevel;
import org.hzz.course.types.enums.CategoryStatus;
import org.hzz.ddd.core.domain.shared.Entity;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Data
public class CategoryEntity implements Entity {
    // 课程分类id
    private Long id;

    // 分类名称
    private String name;

    // 父分类id，一级分类父id为0
    private Long parentId;

    // 分类级别，1,2,3：代表一级分类，二级分类，三级分类
    private CategoryLevel level;

    // 同级目录优先级，数字越小优先级越高，可以重复
    private Integer priority;

    // 课程分类状态，1：正常，2：禁用
    private CategoryStatus status;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    // 创建者Id
    private Long createrId;

    // 更新者Id
    private Long updaterId;

    //
    private Deleted deleted;
}
