package org.hzz.learning.domain.mode;

import java.util.Date;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
public class LearnRecord {
    // 对应小节的id
    private Long sectionId;

    // 视频的当前观看时间点，单位秒
    private Integer moment;

    // 是否完成学习，默认false
    private Boolean finished;

    // 完成学习的时间
    private Date finishTime;
}
