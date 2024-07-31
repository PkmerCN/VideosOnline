package org.hzz.points.application.command.points;

import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.points.application.handler.points.QueryUserPointsCmdHandler;

/**
 * 查询用户今日获取积分情况
 * {@link QueryUserPointsCmdHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Data
@Accessors(chain = true)
@Value(staticConstructor = "commandOf")
public class QueryUserPointsCmd implements CommandWithMark {
    Long userId;
    public static final String MARK = QueryUserPointsCmd.class.getName();
    @Override
    public String mark() {
        return MARK;
    }
}
