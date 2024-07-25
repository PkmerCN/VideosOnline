package org.hzz.remark.application.handler.liked;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.remark.application.command.liked.LikedCommand;
import org.hzz.remark.domain.service.LikedRecordDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/25
 */
@Component
@Slf4j
public class LikedCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<LikedCommand, Void> {

    @Setter(onMethod_ = @Autowired)
    private LikedRecordDomainService likedRecordDomainService;

    @Override
    public String mark() {
        return LikedCommand.MARK;
    }

    @Override
    public void execute(LikedCommand command) {
        Long userId = command.getUserId();
        Long bizId = command.getBizId();

        if (command.getLiked()) {
            log.info("点赞");
            likedRecordDomainService.like(
                    userId,
                    bizId,
                    command.getBizType()
            );
        } else {
            log.info("取消点赞");
            likedRecordDomainService.cancel(
                    userId,
                    bizId
            );
        }
    }
}
