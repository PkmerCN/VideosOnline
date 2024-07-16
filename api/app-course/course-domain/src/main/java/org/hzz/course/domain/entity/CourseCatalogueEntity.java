package org.hzz.course.domain.entity;

import lombok.Data;
import org.hzz.core.enums.delete.Deleted;
import org.hzz.course.types.enums.catalogue.CatalogueType;
import org.hzz.course.types.enums.catalogue.TrailerType;
import org.hzz.ddd.core.domain.shared.Entity;

import java.time.LocalDateTime;

/**
 * 章节实体
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Data
public class CourseCatalogueEntity implements Entity {
    // 课程目录id
    private Long id;

    // 目录名称
    private String name;

    // 是否支持试看
    private TrailerType trailer;

    // 课程id
    private Long courseId;

    // 目录类型1：章，2：节，3：测试
    private CatalogueType type;

    // 所属章id，只有小节和测试有该值，章没有，章默认为0
    private Long parentCatalogueId;

    // 媒资id
    private Long mediaId;

    // 视频id
    private Long videoId;

    // 视频名称
    private String videoName;

    // 直播开始时间
    private LocalDateTime livingStartTime;

    // 直播结束时间
    private LocalDateTime livingEndTime;

    // 是否支持回放
    private Byte playBack;

    // 视频时长，以秒为单位
    private Integer mediaDuration;

    // 用于章节排序
    private Integer cIndex;

    // 部门id
    private Long depId;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    // 创建人Id
    private Long createrId;

    // 更新人Id
    private Long updaterId;

    // 逻辑删除
    private Deleted deleted;
}
