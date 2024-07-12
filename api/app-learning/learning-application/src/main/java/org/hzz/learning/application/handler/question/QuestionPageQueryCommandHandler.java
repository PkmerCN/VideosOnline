package org.hzz.learning.application.handler.question;

import lombok.Setter;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.page.PageResponse;
import org.hzz.core.page.query.PageQuery;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.question.QuestionPageQueryCommand;
import org.hzz.learning.domain.aggregate.question.QuestionQueryAggregate;
import org.hzz.learning.domain.entity.question.InteractionQuestionEntity;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.service.question.InteractionQuestionDomainService;
import org.hzz.learning.domain.service.question.InteractionReplyDomainService;
import org.hzz.learning.types.req.question.QuestionPageQuery;
import org.hzz.learning.types.resp.question.QuestionDto;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.service.details.UserDetailDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 分页查询问题
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Component
public class QuestionPageQueryCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<QuestionPageQueryCommand, PageResponse<QuestionDto>> {

    @Setter(onMethod_ = @Autowired)
    private InteractionQuestionDomainService interactionQuestionDomainService;

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyDomainService interactionReplyDomainService;

    @Setter(onMethod_ = @Autowired)
    private UserDetailDomainService userDetailDomainService;


    @Override
    public String mark() {
        return QuestionPageQueryCommand.MARK;
    }

    @Override
    public PageResponse<QuestionDto> executeWithResp(QuestionPageQueryCommand command) {
        PageResponse<QuestionDto> pageResponse = new PageResponse<>();

        // 问题的列表去查
        PageResponse<InteractionQuestionEntity> results = pageQuery(command);

        pageResponse.setCurrentPageNo(results.getCurrentPageNo())
                .setTotal(results.getTotal())
                .setTotalPages(results.getTotalPages());

        if (CollUtil.isEmpty(results.getList())) {
            return pageResponse;
        }

        List<QuestionDto> questionDtos = handlePageResult(results);
        pageResponse.setList(questionDtos);

        return pageResponse;
    }


    /**
     * 分页查询问题列表
     */
    private PageResponse<InteractionQuestionEntity> pageQuery(QuestionPageQueryCommand command){
        QuestionQueryAggregate aggregate = new QuestionQueryAggregate();
        PageQuery pageQuery = command.getPageQuery();

        // 添加隐藏过滤

        aggregate.setPageQuery(pageQuery);
        return interactionQuestionDomainService.pageQueryEntity(aggregate);
    }


    /**
     * 处理分页结果
     */
    private List<QuestionDto> handlePageResult(PageResponse<InteractionQuestionEntity> results){

        List<InteractionQuestionEntity> questions = results.getList();

        // 获取用户id
        Set<Long> userIds = new HashSet<>();
        Set<Long> answerIds = new HashSet<>();
        for (InteractionQuestionEntity entity : questions) {
            // 在这次循环的过程中顺便把回答的给统计了
            if (entity.getLatestAnswerId() != null) {
                answerIds.add(entity.getLatestAnswerId());
            }
            // 过滤匿名提问和隐藏
            if (entity.getAnonymity() || entity.getHidden()) {
                continue;
            }
            userIds.add(entity.getUserId());
        }

        // 评论
        List<InteractionReplyEntity> replyEntities = interactionReplyDomainService.getEntityByIds(answerIds);

        Map<Long, InteractionReplyEntity> answersMap = new HashMap<>();
        for (InteractionReplyEntity entity: replyEntities){
            answersMap.put(entity.getId(),entity);
            // 处理不匿名用户
            if(!entity.getAnonymity()){
                userIds.add(entity.getUserId());
            }
        }

        return bindUserData(questions,answersMap,userIds);
    }


    /**
     * 处理其他相关数据
     */
    private List<QuestionDto> bindUserData(List<InteractionQuestionEntity> questions,
                              Map<Long, InteractionReplyEntity> answersMap,
                              Set<Long> userIds){
        // 用户
        Map<Long, UserDetailEntity> userDetailEntityMap = userDetailDomainService.getMapEntites(userIds);

        // 组装数据
        List<QuestionDto> dtos = new ArrayList<>(questions.size());
        for(InteractionQuestionEntity entity: questions){
            QuestionDto dto = Converter.INSTANCE.toQuestionDto(entity);
            handleQuestionUser(dto,entity,userDetailEntityMap);
            handleReply(dto,entity,answersMap,userDetailEntityMap);
        }
        return dtos;
    }

    /**
     * 处理提问的用户
     */
    private void handleQuestionUser(
            QuestionDto dto,
            InteractionQuestionEntity entity,
            Map<Long, UserDetailEntity> userDetailEntityMap
    ){
        // 处理匿名用户
        dto.setUserId(null);
        if(!entity.getAnonymity()){
            // 提问的用户id
            Long questionUserId = entity.getUserId();
            // 非匿名用户
            UserDetailEntity userDetailEntity = userDetailEntityMap.get(questionUserId);
            if(userDetailEntity!=null){
                // 在这里设置id
                dto.setUserId(userDetailEntity.getId());
                dto.setUsername(userDetailEntity.getName());
                dto.setUserIcon(userDetailEntity.getIcon());
            }
        }
    }

    /**
     * 处理评论用户与评论内容
     */
    private void handleReply(QuestionDto dto,
                             InteractionQuestionEntity entity,
                             Map<Long, InteractionReplyEntity> answersMap,
                             Map<Long, UserDetailEntity> userDetailEntityMap
                             ){
        // 处理回复
        Long latestAnswerId = entity.getLatestAnswerId();
        InteractionReplyEntity replyEntity = answersMap.get(latestAnswerId);
        if(replyEntity != null){
            dto.setLatestReplyContent(replyEntity.getContent());
            // 处理非匿名评论的用户
            if(!replyEntity.getAnonymity()){
                // 评论者id
                Long replyUserId = replyEntity.getUserId();
                UserDetailEntity userDetailEntity = userDetailEntityMap.get(replyUserId);
                if(userDetailEntity != null){
                    dto.setLatestReplyUser(userDetailEntity.getName());
                }
            }
        }
    }

    @Mapper
    interface Converter{
        Converter INSTANCE = Mappers.getMapper(Converter.class);

        QuestionDto toQuestionDto(InteractionQuestionEntity entity);
        InteractionQuestionEntity toInteractionQuestionEntity(QuestionDto dto);
    }
}
