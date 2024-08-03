package org.hzz.points.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.Entity;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/3
 */
@Data
@Accessors(chain = true)
public class PointsBoardEntity implements Entity {
    private Long id;

    // 学生id
    private Long userId;

    // 积分值
    private Integer points;

    // 名次，只记录赛季前100
    private Byte rank;

    // 赛季id
    private Short season;
}
