package org.hzz.learning.domain.entity;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.Entity;

/**
 * 用户实体
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
@Data
public class LearnRecordEntity implements Entity {
    private Long id;
    private Integer moment;
    private Boolean finished;
}
