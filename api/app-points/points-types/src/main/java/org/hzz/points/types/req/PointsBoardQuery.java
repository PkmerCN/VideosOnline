package org.hzz.points.types.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hzz.core.page.query.PageQuery;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PointsBoardQuery extends PageQuery {
    @Schema(description = "赛季id",example = "如果为空那么查询的是当前赛季")
    private Integer seasonId;
}
