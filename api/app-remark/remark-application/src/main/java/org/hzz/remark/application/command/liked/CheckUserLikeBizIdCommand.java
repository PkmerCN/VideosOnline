package org.hzz.remark.application.command.liked;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.remark.application.handler.liked.CheckUserLikeBizIdCommandHandler;

import java.util.Set;

/**
 * {@link CheckUserLikeBizIdCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/26
 */
@Data
@Accessors(chain = true)
public class CheckUserLikeBizIdCommand implements CommandWithMark {
    public static final String MARK = CheckUserLikeBizIdCommand.class.getName();

    Set<Long> bizIds;
    Long userId;

    @Override
    public String mark() {
        return MARK;
    }
}
