package org.hzz.remark.application.command.liked;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.command.CommandWithMark;
import org.hzz.remark.application.handler.liked.LikedCommandHandler;
import org.hzz.remark.types.BizType;

/**
 * 点赞或者取消点赞命令
 * {@link LikedCommandHandler}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Data
public class LikedCommand implements CommandWithMark {

    public static final String MARK = LikedCommand.class.getName();
    // 业务id
    Long bizId;
    // 业务类型
    BizType bizType;
    // 点赞（true）还是取消点赞(false)，
    Boolean liked;

    @Override
    public String mark() {
        return MARK;
    }
}
