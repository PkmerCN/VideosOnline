package org.hzz.learning.application.handler.plan;

import lombok.Setter;
import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.FilterCondition;
import org.hzz.core.page.query.PageQuery;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.plan.PlanPageQueryCommand;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.learning.domain.enums.LessonStatus;
import org.hzz.learning.domain.enums.PlanStatus;
import org.hzz.learning.domain.service.LearnLessonRecordDomainService;
import org.hzz.learning.domain.service.LearningLessonPageService;
import org.hzz.learning.types.resp.plan.LearnPlanDto;
import org.hzz.learning.types.resp.plan.LearnPlansPageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 处理学习计划分页查询
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Component
public class PlanPageQueryCommandHandler implements AbstractExecuteStrategy<PlanPageQueryCommand, LearnPlansPageResult> {

    @Setter(onMethod_ = @Autowired)
    private LearningLessonPageService lessonPageService;

    @Setter(onMethod_ = @Autowired)
    private LearnLessonRecordDomainService recordDomainService;

    @Override
    public String mark() {
        return PlanPageQueryCommand.MARK;
    }

    @Override
    public LearnPlansPageResult executeWithResp(PlanPageQueryCommand planPageQueryCommand) {
        // 添加条件
        // userId在Controller层已经处理了。
        PageQuery pageQuery = planPageQueryCommand.getPageQuery();
        List<FilterCondition> filters = pageQuery.getFilters();

        // 添加课程状态以及计划状态
        filters.add(new FilterCondition("status", "in", String.format("(%d,%d,%d)",
                LessonStatus.LEARNING.getValue(),
                LessonStatus.FINISHED.getValue(),
                LessonStatus.NOT_BEGIN.getValue())));
        filters.add(new FilterCondition("plan_status", "=", PlanStatus.PLAN_RUNNING.getValue()));

        // 查询
        PageResponse<LearningLessonAggregate> results = lessonPageService
                .pageQueryLesson(LearningLessonAggregate
                        .builder()
                        .pageQuery(pageQuery)
                        .build());
        // 从学习记录统计本周学习的记录

        // 转换为LearnPlanDto
        List<LearnPlanDto> learnPlanDtos = handleLearnPlanDto(results.getList());


        // 封装结果
        LearnPlansPageResult plansPageResult = new LearnPlansPageResult();

        // todo 积分
        plansPageResult
                .setWeekPoints(0) // todo 目前积分设置为0
                .setWeekTotalPlan(0)
                .setWeekFinished(0)
                .setCurrentPageNo(results.getCurrentPageNo())
                .setTotal(results.getTotal())
                .setList(learnPlanDtos);

        return plansPageResult;
    }

    private List<LearnPlanDto> handleLearnPlanDto(List<LearningLessonAggregate> aggregates) {


        List<LearnPlanDto> results = new ArrayList<>();
        // vo转换
        for (LearningLessonAggregate el : aggregates) {
            LearnPlanDto dto = new LearnPlanDto();

            dto.courseId(el.getCourse().getId())
                    .courseName(el.getCourse().getName())
                    .sections(el.getCourse().getSectionNum())
                    .latestLearnTime(el.getLatestLearnTime())
                    .learnedSections(el.getLearnedSections())
                    .weekFreq(Integer.valueOf(el.getWeekFreq()));

            results.add(dto);
        }

        return results;
    }

}
