package org.hzz.learning.application.handler.question;

import lombok.Setter;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.GetQuestionCommand;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.hzz.learning.types.resp.question.QuestionDetailDto;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.service.details.UserDetailDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 获取问题详情
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Component
public class GetQuestionCommandHandler implements AbstractExecuteStrategy<GetQuestionCommand, QuestionDetailDto> {

    @Setter(onMethod_ = @Autowired)
    private InteractionQuestionDomainService questionDomainService;

    @Setter(onMethod_ = @Autowired)
    private UserDetailDomainService userDetailDomainService;
    @Override
    public String mark() {
        return GetQuestionCommand.MARK;
    }

    @Override
    public QuestionDetailDto executeWithResp(GetQuestionCommand command) {
        InteractionQuestionEntity entity = questionDomainService.getEntityById(command.getId());
        QuestionDetailDto dto = Converter.INSTANCE.toDto(entity);
        // 封装用户的信息
        handleUserInfo(dto);
        return dto;
    }

    /**
     * 封装用户信息
     */
    private void handleUserInfo(QuestionDetailDto dto){
        UserDetailEntity userDetail = userDetailDomainService.getEntityById(dto.getUserId());

        dto.setUsername(userDetail.getName());
        dto.setUserIcon(userDetail.getIcon());
    }

    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);

        QuestionDetailDto toDto(InteractionQuestionEntity entity);
    }
}
