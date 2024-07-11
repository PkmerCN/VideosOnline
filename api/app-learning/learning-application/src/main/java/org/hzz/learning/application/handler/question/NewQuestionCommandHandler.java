package org.hzz.learning.application.handler.question;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.NewQuestionCommand;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/11
 */
@Component
public class NewQuestionCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<NewQuestionCommand,Void> {

    @Setter(onMethod_ = @Autowired)
    private InteractionQuestionDomainService interactionQuestionDomainService;

    @Override
    public String mark() {
        return NewQuestionCommand.MASK;
    }

    @Override
    public void execute(NewQuestionCommand command) {
        InteractionQuestionEntity entity = Converter.INSTANCE.toEntity(command);
        interactionQuestionDomainService.newQuestion(entity);
    }

    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);

        InteractionQuestionEntity toEntity(NewQuestionCommand command);
    }
}
