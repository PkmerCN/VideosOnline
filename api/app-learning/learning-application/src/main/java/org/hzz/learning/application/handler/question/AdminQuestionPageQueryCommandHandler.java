package org.hzz.learning.application.handler.question;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.common.tree.BaseConverter;
import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.FilterCondition;
import org.hzz.core.page.query.PageQuery;
import org.hzz.course.cache.category.CategoryCache;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.domain.service.course.CourseDomainService;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.AdminQuestionPageQueryCommand;
import org.hzz.learning.domain.aggregate.question.QuestionQueryAggregate;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.hzz.learning.types.resp.question.AdminQuestionDetailVo;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.service.details.UserDetailDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hzz.core.page.query.FilterCondition.Operation;

import java.util.*;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/13
 */
@Component
public class AdminQuestionPageQueryCommandHandler
        implements CommandHandler,
        AbstractExecuteStrategy<AdminQuestionPageQueryCommand, PageResponse<AdminQuestionDetailVo>>
{
    @Setter(onMethod_ = @Autowired)
    private InteractionQuestionDomainService questionDomainService;

    @Setter(onMethod_ = @Autowired)
    private UserDetailDomainService userDetailDomainService;

    @Setter(onMethod_ = @Autowired)
    private CourseDomainService courseDomainService;

    @Setter(onMethod_ = @Autowired)
    private CategoryCache categoryCache;


    @Override
    public PageResponse<AdminQuestionDetailVo> executeWithResp(AdminQuestionPageQueryCommand command) {

        PageResponse<AdminQuestionDetailVo> result = new PageResponse<>();

        // 分页查询
        PageResponse<InteractionQuestionEntity> questionPage = pageQuery(command);
        result.setTotalPages(questionPage.getTotalPages())
                .setTotal(questionPage.getTotal())
                .setCurrentPageNo(questionPage.getCurrentPageNo());


        List<InteractionQuestionEntity> questionEntities = questionPage.getList();
        if(CollUtil.isEmpty(questionEntities)){
            result.setList(new ArrayList<>());
            return result;
        }

        // 处理用户
        Set<Long> userIds = new HashSet<>();
        Set<Long> courseIds = new HashSet<>();
        Set<Long> catalogueIds = new HashSet<>();
        for (InteractionQuestionEntity entity: questionEntities){
            userIds.add(entity.getUserId());
            courseIds.add(entity.getCourseId());
            catalogueIds.add(entity.getChapterId());
            catalogueIds.add(entity.getSectionId());
        }

        Map<Long, UserDetailEntity> mapUserDetailEntites = userDetailDomainService.getMapEntites(userIds);
        Map<Long, CourseEntity> mapCourseEntities = courseDomainService.getMapCourseEntities(courseIds);

        List<AdminQuestionDetailVo> voList = new ArrayList<>();
        for (InteractionQuestionEntity entity: questionEntities){
            AdminQuestionDetailVo vo = AdminQuestionDetailVoConverter.INSTANCE.convert(entity);
            // 处理用户
            UserDetailEntity userDetailEntity = mapUserDetailEntites.get(entity.getUserId());
            vo.setUsername(userDetailEntity.getName());

            // 处理课程
            CourseEntity course = mapCourseEntities.get(entity.getCourseId());
            // 课程名称
            vo.setCourseName(course.getName());
            // 分类名称
            String categoryName = categoryCache.getCategoryName(course.getCategoryIds());
            vo.setCategoryName(categoryName);
            // 处理章节
            // todo 章节的处理

            voList.add(vo);
        }

        result.setList(voList);
        return result;
    }


    private PageResponse<InteractionQuestionEntity> pageQuery(AdminQuestionPageQueryCommand command){

        PageQuery pageQuery = command.getPageQuery();
        List<FilterCondition> filters = new ArrayList<>();

        // todo courseName es去做 查询出id

        if(command.getStatus() != null){
            FilterCondition condition = new FilterCondition(
                    "status",
                    Operation.Equal,
                    command.getStatus());
            filters.add(condition);
        }

        if(command.getBeginTime() != null){
            FilterCondition condition = new FilterCondition(
                    "create_time",
                    Operation.GreaterOrEqual,
                    command.getBeginTime());
            filters.add(condition);
        }

        if(command.getEndTime() != null){
            FilterCondition condition = new FilterCondition(
                    "create_time",
                    Operation.LessOrEqual,
                    command.getEndTime());
            filters.add(condition);
        }

        pageQuery.setFilters(filters);

        QuestionQueryAggregate aggregate = new QuestionQueryAggregate();
        aggregate.setPageQuery(pageQuery);

        return questionDomainService.pageQueryEntity(aggregate);
    }

    @Override
    public String mark() {
        return AdminQuestionPageQueryCommand.MARK;
    }

    @Mapper
    interface AdminQuestionDetailVoConverter extends BaseConverter<AdminQuestionDetailVo,InteractionQuestionEntity>{
        AdminQuestionDetailVoConverter INSTANCE = Mappers.getMapper(AdminQuestionDetailVoConverter.class);
    }

}
