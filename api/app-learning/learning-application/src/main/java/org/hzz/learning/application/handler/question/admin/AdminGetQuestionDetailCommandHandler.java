package org.hzz.learning.application.handler.question.admin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hzz.course.cache.category.CategoryCache;
import org.hzz.course.domain.entity.CourseEntity;
import org.hzz.course.domain.service.catalogue.CatalogueDomainService;
import org.hzz.course.domain.service.course.CourseDomainService;
import org.hzz.course.domain.service.teacher.CourseTeacherDomainService;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.admin.AdminGetQuestionDetailCommand;
import org.hzz.learning.application.converter.AdminQuestionDetailVoConverter;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.hzz.learning.types.enums.question.QuestionStatus;
import org.hzz.learning.types.resp.question.AdminQuestionDetailVo;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.service.details.UserDetailDomainService;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/16
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class AdminGetQuestionDetailCommandHandler
        implements AbstractExecuteStrategy<AdminGetQuestionDetailCommand, AdminQuestionDetailVo>,
        CommandHandler {

    private final InteractionQuestionDomainService questionDomainService;

    private final UserDetailDomainService userDetailDomainService;

    private final CourseDomainService courseDomainService;

    private final CatalogueDomainService catalogueDomainService;

    private final CategoryCache categoryCache;

    private final CourseTeacherDomainService teacherDomainService;

    private final AdminQuestionDetailVoConverter CONVERTER;

    @Override
    public String mark() {
        return AdminGetQuestionDetailCommand.MARK;
    }

    @Override
    public AdminQuestionDetailVo executeWithResp(AdminGetQuestionDetailCommand command) {
        Long questionId = command.getQuestionId();

        final InteractionQuestionEntity entity = questionDomainService.getEntityById(questionId);

        AdminQuestionDetailVo vo = CONVERTER.convert(entity);

        bindData(entity,vo);

        if(QuestionStatus.UN_CHECK.equals(entity.getStatus())){
            // 如果未查看，设置为已查看,异步线程来做
            CompletableFuture.runAsync(() -> {
                log.info("设置问题状态为已经查看 id = {}",entity.getId());
                entity.setStatus(QuestionStatus.CHECKED);
                questionDomainService.modifyQuestion(entity);
            });
        }

        return vo;
    }

    public void bindData(InteractionQuestionEntity entity,AdminQuestionDetailVo vo){
        // 课程
        CourseEntity course = handleCourseInfo(entity,vo);

        // 处理提问用户和老师
        handleUserInfo(entity,vo,course);
    }

    /**
     * 处理用户数据
     */
    private void handleUserInfo(InteractionQuestionEntity entity,
                                AdminQuestionDetailVo vo,
                                CourseEntity course){
        // 老师
        List<Long> teacherIds = teacherDomainService.getTeacherIds(course.getId());

        // 用户 一次性查询提问用户和课程老师
        Set<Long> userIds = new HashSet<>();
        userIds.add(entity.getUserId());
        userIds.addAll(teacherIds);

        Map<Long, UserDetailEntity> mapEntities = userDetailDomainService.getMapEntities(userIds);

        UserDetailEntity questionUserDetail = mapEntities.get(entity.getUserId());

        // 拼接老师的名称
        String teacherName = mapEntities.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(entity.getUserId()))
                .map(entry -> entry.getValue().getName())
                .collect(Collectors.joining("/"));

        vo.setUsername(questionUserDetail.getName());
        vo.setTeacherName(teacherName);
    }

    /**
     * 处理课程数据
     */
    private CourseEntity handleCourseInfo(InteractionQuestionEntity entity,
                                  AdminQuestionDetailVo vo){
        // 课程
        CourseEntity course = courseDomainService.findCourse(entity.getCourseId());
        // 课程名称
        vo.setCourseName(course.getName());
        // 分类名称
        String categoryName = categoryCache.getCategoryName(course.getCategoryIds());
        vo.setCategoryName(categoryName);

        // 处理课程的章节
        handleCatalogueInfo(entity,vo,course);

        return course;
    }

    /**
     * 处理章节数据
     */
    private void handleCatalogueInfo(InteractionQuestionEntity entity,
                                     AdminQuestionDetailVo vo,
                                     CourseEntity course){
        Set<Long> ids = new HashSet<>();
        ids.add(entity.getSectionId());
        ids.add(entity.getChapterId());

        Map<Long, String> mapCatalogue = catalogueDomainService.getMapIdAndName(ids);
        // 处理章名称
        vo.setChapterName(mapCatalogue.getOrDefault(entity.getChapterId(),""));
        // 处理小节名称
        vo.setSectionName(mapCatalogue.getOrDefault(entity.getSectionId(),""));
    }
}
