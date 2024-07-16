package org.hzz.learning.application.handler.question;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.AdminHiddenQuestionCommand;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 处理问题隐藏
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Component
@Slf4j
public class AdminHiddenQuestionCommandHandler
        implements AbstractExecuteStrategy<AdminHiddenQuestionCommand,Void> {

    @Setter(onMethod_ = @Autowired)
    private InteractionQuestionDomainService questionDomainService;

    @Override
    public String mark() {
        return AdminHiddenQuestionCommand.MARK;
    }

    @Override
    public void execute(AdminHiddenQuestionCommand command) {
        Long id = command.getId();
        InteractionQuestionEntity entity = questionDomainService.getEntityById(id);
        if(entity == null){
            throw new BadRequestException("id = "+id+" 的记录不存在");
        }

        if(entity.getHidden().equals(command.getHidden())){
            log.info("问题已经处于 hidden = {},不再设置",entity.getHidden());
            return;
        }

        // 设置问题
        entity.setHidden(command.getHidden());
        questionDomainService.modifyQuestion(entity);
    }
}
