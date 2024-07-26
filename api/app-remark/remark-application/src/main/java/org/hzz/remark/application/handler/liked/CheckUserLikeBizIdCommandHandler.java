package org.hzz.remark.application.handler.liked;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.remark.application.command.liked.CheckUserLikeBizIdCommand;
import org.hzz.remark.domain.service.LikedRecordDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/26
 */
@Component
public class CheckUserLikeBizIdCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<CheckUserLikeBizIdCommand, Set<Long>> {

    @Setter(onMethod_ = @Autowired)
    private LikedRecordDomainService domainService;
    @Override
    public String mark() {
        return CheckUserLikeBizIdCommand.MARK;
    }

    @Override
    public Set<Long> executeWithResp(CheckUserLikeBizIdCommand cmd) {

        return domainService.checkUserLikeBizId(
                cmd.getUserId(),
                cmd.getBizIds()
        );
    }
}
