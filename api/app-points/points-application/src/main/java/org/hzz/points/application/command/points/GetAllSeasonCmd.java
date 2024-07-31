package org.hzz.points.application.command.points;

import lombok.Data;
import lombok.Value;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.points.application.handler.points.GetAllSeasonCmdHandler;

/**
 * 获取全部赛季
 * {@link GetAllSeasonCmdHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/31
 */
@Data
@Value(staticConstructor = "commandOf")
public class GetAllSeasonCmd implements CommandWithMark {
    public static final String MARK = GetAllSeasonCmd.class.getName();
    @Override
    public String mark() {
        return MARK;
    }
}
