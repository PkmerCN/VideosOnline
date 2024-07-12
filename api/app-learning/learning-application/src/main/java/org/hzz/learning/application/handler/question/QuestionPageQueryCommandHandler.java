package org.hzz.learning.application.handler.question;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.page.PageResponse;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.QuestionPageQueryCommand;
import org.hzz.learning.domain.aggregate.question.QuestionQueryAggregate;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.hzz.learning.types.resp.question.QuestionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Component
public class QuestionPageQueryCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<QuestionPageQueryCommand, PageResponse<QuestionDto>> {

    @Setter(onMethod_ = @Autowired)
    private InteractionQuestionDomainService interactionQuestionDomainService;

    @Override
    public String mark() {
        return QuestionPageQueryCommand.MARK;
    }

    @Override
    public PageResponse<QuestionDto> executeWithResp(QuestionPageQueryCommand command) {
        PageResponse<QuestionDto> pageResponse = new PageResponse<>();
        QuestionQueryAggregate aggregate = new QuestionQueryAggregate();

        // todo 条件在controller添加

        // 问题的列表去查
        PageResponse<InteractionQuestionEntity> results = interactionQuestionDomainService.pageQueryEntity(aggregate);
        if(results == null || CollUtil.isEmpty(results.getList())){
            return pageResponse;
        }

        // 获取用户id
        Set<Long> userIds = new HashSet<>();
        Set<Long> answerIds = new HashSet<>();
        for (InteractionQuestionEntity entity: results.getList()){
            // 在这次循环的过程中顺便把回答的给统计了
            if(entity.getLatestAnswerId() != null){
                answerIds.add(entity.getLatestAnswerId());
            }
            // 过滤匿名提问和隐藏
            if(entity.getAnonymity() || entity.getHidden()){
                continue;
            }
            userIds.add(entity.getUserId());
        }



        // 获取问题

        return pageResponse;
    }
}
