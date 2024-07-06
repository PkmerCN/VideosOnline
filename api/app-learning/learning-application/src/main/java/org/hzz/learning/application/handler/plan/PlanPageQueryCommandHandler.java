package org.hzz.learning.application.handler.plan;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.FilterCondition;
import org.hzz.core.page.query.PageQuery;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.plan.PlanPageQueryCommand;
import org.hzz.learning.domain.aggregate.LearningLessonAggregate;
import org.hzz.learning.domain.entity.IdAndNumEntity;
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
import java.util.Map;

/**
 * 处理学习计划分页查询
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/4
 */
@Component
@Slf4j
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
    public LearnPlansPageResult executeWithResp(PlanPageQueryCommand command) {
        LearnPlansPageResult plansPageResult = createEmptyLearnPlansPageResult();

        PageResponse<LearningLessonAggregate> results = getLessonPage(command);

        if(results != null && CollUtil.isEmpty(results.getList())){
            log.info("该用户userId = {}没有学习课程",command.getUserId());
            return plansPageResult;
        }

        List<IdAndNumEntity> idAndNumEntities = getUserWeekLearnSections(command.getUserId());
        List<LearnPlanDto> learnPlanDtos = convertToLearnPlanDto(results.getList(),idAndNumEntities);

        // 统计本周已经学习的小节数量
        Integer weekFinished = idAndNumEntities.stream()
                .map(IdAndNumEntity::getNum)
                .reduce(0, Integer::sum);

        // 统计本周计划的小节数量
        Integer weekTotalPlan = results.getList().stream()
                        .reduce(0,(acc,el) ->  acc + el.getWeekFreq(),Integer::sum);


        // todo 积分

        plansPageResult
                .setWeekPoints(0) // todo 目前积分设置为0
                .setWeekTotalPlan(weekTotalPlan)
                .setWeekFinished(weekFinished)
                .setCurrentPageNo(results.getCurrentPageNo())
                .setTotal(results.getTotal())
                .setTotalPages(results.getTotalPages())
                .setList(learnPlanDtos);

        return plansPageResult;
    }


    private LearnPlansPageResult createEmptyLearnPlansPageResult(){
        LearnPlansPageResult plansPageResult = new LearnPlansPageResult();
        plansPageResult
                .setWeekPoints(0) // todo 目前积分设置为0
                .setWeekTotalPlan(0)
                .setWeekFinished(0)
                .setCurrentPageNo(0)
                .setTotal(0)
                .setTotalPages(0)
                .setList(new ArrayList<>());

        return plansPageResult;
    }

    private PageResponse<LearningLessonAggregate> getLessonPage(PlanPageQueryCommand command){
        // 添加条件
        // userId在Controller层已经处理了。
        PageQuery pageQuery = command.getPageQuery();
        List<FilterCondition> filters = pageQuery.getFilters();

        // 添加课程状态以及计划状态
        filters.add(new FilterCondition("status", "in", List.of(
                LessonStatus.LEARNING.getValue(),
                LessonStatus.FINISHED.getValue(),
                LessonStatus.NOT_BEGIN.getValue()
        )));
        filters.add(new FilterCondition("plan_status", "=", PlanStatus.PLAN_RUNNING.getValue()));

        // 查询
        return lessonPageService.pageQueryLesson(LearningLessonAggregate
                        .builder()
                        .pageQuery(pageQuery)
                        .build());
    }

    /**
     * 从学习记录统计本周学习的记录
     */
    private List<IdAndNumEntity> getUserWeekLearnSections(Long userId){
        return recordDomainService.countUserWeekLearnSections(userId);
    }

    /**
     * 转换为LearnPlanDto
     */
    private List<LearnPlanDto> convertToLearnPlanDto(List<LearningLessonAggregate> aggregates, List<IdAndNumEntity> idAndNumEntities) {

        Map<Long, Integer> idsMap = IdAndNumEntity.toMap(idAndNumEntities);

        List<LearnPlanDto> results = new ArrayList<>();
        // vo转换
        for (LearningLessonAggregate el : aggregates) {
            LearnPlanDto dto = new LearnPlanDto();

            dto.courseId(el.getCourse().getId())
                    .courseName(el.getCourse().getName())
                    .sections(el.getCourse().getSectionNum())
                    .latestLearnTime(el.getLatestLearnTime())
                    .learnedSections(el.getLearnedSections())
                    .weekLearnedSections(idsMap.getOrDefault(el.getId(),0))
                    .weekFreq(Integer.valueOf(el.getWeekFreq()));

            results.add(dto);
        }

        return results;
    }
}
