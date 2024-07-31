package org.hzz.points.domain.entity;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.Entity;

import java.time.LocalDate;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Data
public class PointsBoardSeasonEntity implements Entity {
    // 自增长id，season标示
    private Integer id;

    // 赛季名称，例如：第1赛季
    private String name;

    // 赛季开始时间
    private LocalDate beginTime;

    // 赛季结束时间
    private LocalDate endTime;
}
