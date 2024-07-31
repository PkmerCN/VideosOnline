package org.hzz.points.application.handler.sign;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.points.application.command.sign.QuerySignRecordsCmd;
import org.hzz.points.domain.service.sign.SignDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 查询用户本月签到记录策略
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Component
public class QuerySignRecordsCmdHandler implements CommandHandler,
        AbstractExecuteStrategy<QuerySignRecordsCmd,int[]> {

    @Setter(onMethod_ = @Autowired)
    private SignDomainService signDomainService;

    @Override
    public String mark() {
        return QuerySignRecordsCmd.MARK;
    }

    /**
     * 例如今天是7月31号，查询到的签到记录
     * [1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1]
     */
    @Override
    public int[] executeWithResp(QuerySignRecordsCmd cmd) {
        return signDomainService.querySignRecordsForToday(cmd.getUserId());
    }
}
