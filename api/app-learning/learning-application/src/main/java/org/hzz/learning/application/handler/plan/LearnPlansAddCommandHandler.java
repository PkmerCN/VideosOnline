package org.hzz.learning.application.handler.plan;

import lombok.Setter;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.plan.LearnPlansAddCommand;
import org.hzz.learning.domain.entity.LearningLessonEntity;
import org.hzz.learning.types.enums.lesson.PlanStatus;
import org.hzz.learning.domain.service.lesson.LearnLessonDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.hzz.learning.application.handler.MarkConstants.LEARN_PLAN_ADD;

/**
 * 处理添加课程
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Component
public class LearnPlansAddCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<LearnPlansAddCommand,Boolean> {

    @Setter(onMethod_ = @Autowired)
    private LearnLessonDomainService learnLessonDomainService;

    @Override
    public String mark() {
        return LEARN_PLAN_ADD;
    }

    @Override
    public void execute(LearnPlansAddCommand command) {
        LearningLessonEntity entity = learnLessonDomainService.queryLesson(command.getUserId(), command.getCourseId());
        entity.setWeekFreq(command.getFreq().byteValue());
        entity.setPlanStatus(PlanStatus.PLAN_RUNNING);
        // 领域
        learnLessonDomainService.updateLessonSelectiveById(entity);
    }
}
