package org.hzz.points.application.command.sign;

import lombok.Data;
import lombok.Value;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.points.application.handler.sign.QuerySignRecordsCmdHandler;

/**
 * 查询用户本月签到记录命令
 * {@link QuerySignRecordsCmdHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Data
@Value(staticConstructor = "commandOf")
public class QuerySignRecordsCmd implements CommandWithMark {
    Long userId;


    public static final String MARK = QuerySignRecordsCmd.class.getName();
    @Override
    public String mark() {
        return MARK;
    }
}
