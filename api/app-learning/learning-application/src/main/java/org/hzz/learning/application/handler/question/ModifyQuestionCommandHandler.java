package org.hzz.learning.application.handler.question;

import cn.hutool.core.util.StrUtil;
import lombok.Setter;
import org.hzz.core.exception.request.BadRequestException;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.ModifyQuestionCommand;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 处理修改问题
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Component
public class ModifyQuestionCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<ModifyQuestionCommand,Void> {

    @Setter(onMethod_ = @Autowired)
    private InteractionQuestionDomainService interactionQuestionDomainService;

    @Override
    public String mark() {
        return ModifyQuestionCommand.MASK;
    }

    @Override
    public void execute(ModifyQuestionCommand command) {
        InteractionQuestionEntity entity = interactionQuestionDomainService.getEntityById(command.id());

        if(!command.userId().equals(entity.getUserId())){
            throw new BadRequestException(StrUtil.format("该用户（id = {}）没有权限修改其他人的问题",command.id()));
        }

        InteractionQuestionEntity newEntity = Converter.INSTANCE.toEntity(command);
        interactionQuestionDomainService.modifyQuestion(newEntity);
    }


    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);

        InteractionQuestionEntity toEntity(ModifyQuestionCommand command);
    }
}
