package org.hzz.remark.domain.entity;

import org.hzz.ddd.core.domain.shared.Entity;
import org.hzz.remark.types.BizType;

import java.time.LocalDateTime;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
public class LikedRecordEntity implements Entity {
    // 主键id
    private Long id;

    // 用户id
    private Long userId;

    // 点赞的业务id
    private Long bizId;

    // 点赞的业务类型
    private BizType bizType;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;
}
