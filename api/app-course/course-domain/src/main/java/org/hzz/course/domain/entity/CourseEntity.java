package org.hzz.course.domain.entity;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.Entity;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/26
 */
@Data
public class CourseEntity implements Entity {
    // 课程草稿id，对应正式草稿id
    private Long id;

    // 课程名称
    private String name;
    // 封面链接
    private String coverUrl;

    // 课程价格，单位为分
    private Integer price;
    // 课程状态
    private Byte status;

    // 是否是免费课程
    private Boolean free;

    // 一级课程分类id
    private Long firstCateId;

    // 二级课程分类id
    private Long secondCateId;

    // 三级课程分类id
    private Long thirdCateId;

    // 小节数量
    private Integer sectionNum;

    // 课程购买有效期结束时间
    private LocalDateTime purchaseEndTime;

    // 课程学习有效期，单位：月
    private Integer validDuration;
}
