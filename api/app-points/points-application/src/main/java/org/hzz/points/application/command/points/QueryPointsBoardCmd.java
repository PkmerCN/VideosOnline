package org.hzz.points.application.command.points;

import lombok.Data;
import lombok.Value;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.points.application.handler.points.QueryPointsBoardCmdHandler;
import org.hzz.points.types.req.PointsBoardQuery;

/**
 * 获取积分排行榜命令
 * {@link QueryPointsBoardCmdHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/4
 */
@Data
@Value(staticConstructor = "commandOf")
public class QueryPointsBoardCmd implements CommandWithMark {
    Long userId;
    PointsBoardQuery pointsBoardQuery;

    public static final String MARK = QueryPointsBoardCmd.class.getName();
    @Override
    public String mark() {
        return MARK;
    }

    /**
     * 查询的是当前赛季还是历史赛季
     * @return true 当前赛季 false 历史赛季
     */
    public boolean currentOrHistory(){
        Integer seasonId = pointsBoardQuery.getSeasonId();
        return seasonId == null || seasonId == 0;
    }
}
