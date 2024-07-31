package org.hzz.points.application.handler.points;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.points.application.command.points.QueryUserPointsCmd;
import org.hzz.points.domain.service.points.PointsDomainService;
import org.hzz.points.types.resp.PointsStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Component
public class QueryUserPointsCmdHandler implements CommandHandler,
        AbstractExecuteStrategy<QueryUserPointsCmd, List<PointsStatisticsVo>> {

    @Setter(onMethod_ = @Autowired)
    private PointsDomainService pointsDomainService;

    @Override
    public String mark() {
        return QueryUserPointsCmd.MARK;
    }

    @Override
    public List<PointsStatisticsVo> executeWithResp(QueryUserPointsCmd cmd) {
        return pointsDomainService.queryUserPointsForToday(cmd.getUserId());
    }
}
