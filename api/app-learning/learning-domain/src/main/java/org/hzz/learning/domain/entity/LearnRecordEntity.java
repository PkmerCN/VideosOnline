package org.hzz.learning.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.Entity;

import java.time.LocalDateTime;

/**
 * 用户实体
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
@Accessors(chain = true)
public class LearnRecordEntity implements Entity {
    // 学习记录的id
    private Long id;

    // 对应课表的id
    private Long lessonId;

    // 对应小节的id
    private Long sectionId;

    // 用户id
    private Long userId;

    // 视频的当前观看时间点，单位秒
    private Integer moment;

    // 是否完成学习，默认false
    private Boolean finished;

    // 完成学习的时间
    private LocalDateTime finishTime;
}
