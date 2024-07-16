package org.hzz.course.domain.entity;

import lombok.Data;
import org.hzz.core.enums.delete.Deleted;
import org.hzz.course.types.enums.teacher.IsShow;
import org.hzz.ddd.core.domain.shared.Entity;

import java.time.LocalDateTime;

/**
 * 教师实体
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Data
public class CourseTeacherEntity implements Entity {
    // 课程老师关系id
    private Long id;

    // 课程id
    private Long courseId;

    // 老师id
    private Long teacherId;

    // 用户端是否展示
    private IsShow isShow;

    // 序号
    private Integer cIndex;

    // 部门id
    private Long depId;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    // 创建人ID
    private Long createrId;

    // 更新人ID
    private Long updaterId;

    // 逻辑删除
    private Deleted deleted;
}
