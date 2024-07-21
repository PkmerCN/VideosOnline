package org.hzz.learning.application.handler.reply;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.collection.CollUtil;
import org.hzz.core.converter.TargetAndSourceConverter;
import org.hzz.core.page.PageResponse;
import org.hzz.ddd.core.domain.shared.command.CommandHandler;
import org.hzz.design.pattern.strategy.AbstractExecuteStrategy;
import org.hzz.learning.application.command.reply.PageQueryReplyCommand;
import org.hzz.learning.domain.entity.question.InteractionReplyEntity;
import org.hzz.learning.domain.service.reply.InteractionReplyDomainService;
import org.hzz.learning.types.resp.reply.ReplyResp;
import org.hzz.learning.types.resp.reply.ReplyUserResp;
import org.hzz.user.domain.entity.UserDetailEntity;
import org.hzz.user.domain.service.details.UserDetailDomainService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 处理分页查询回答或者评论
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/20
 */
@Component
@Slf4j
public class PageQueryReplyCommandHandler implements CommandHandler,
        AbstractExecuteStrategy<PageQueryReplyCommand, PageResponse<ReplyResp>> {

    @Setter(onMethod_ = @Autowired)
    private InteractionReplyDomainService replyDomainService;

    @Setter(onMethod_ = @Autowired)
    private UserDetailDomainService userDetailDomainService;

    @Override
    public String mark() {
        return PageQueryReplyCommand.MARK;
    }

    @Override
    public PageResponse<ReplyResp> executeWithResp(PageQueryReplyCommand command) {

        // todo 标记用户是否点赞过
        // 分页
        PageResponse<InteractionReplyEntity> pageEntities = selectPage(command);

        // 直接转化
        PageResponse<ReplyResp> pageResp = Converter.INSTANCE.convertToTargetPage(pageEntities);

        List<InteractionReplyEntity> entities = pageEntities.getList();

        if (CollUtil.isEmpty(entities)) {
            log.info("查询结果为空");
            pageResp.setList(Collections.emptyList());
            return pageResp;
        } else {
            List<ReplyResp> replyResp = handleUserInfo(
                    entities,
                    command.isComment());
            pageResp.setList(replyResp);
        }

        return pageResp;
    }


    /**
     * 处理分页查询
     */
    public PageResponse<InteractionReplyEntity> selectPage(PageQueryReplyCommand command) {
        PageResponse<InteractionReplyEntity> pageEntities;

        if (command.isComment()) {
            log.info("分页查询评论");
            pageEntities = replyDomainService.selectCommentPage(
                    command.getQuestionId(),
                    command.getAnswerId(),
                    command.getPageQuery()
            );
        } else {
            log.info("分页查询回答");
            pageEntities = replyDomainService.selectReplyPage(
                    command.getQuestionId(),
                    command.getPageQuery()
            );
        }

        return pageEntities;
    }

    /**
     * 处理用户信息
     *
     * @param entities 具体数据
     * @param isComment 是否是评论 true处理评论，false处理回答
     */
    public List<ReplyResp> handleUserInfo(List<InteractionReplyEntity> entities,boolean isComment) {
        // 收集回答用户id
        Set<Long> userIds = entities.stream().map(InteractionReplyEntity::getUserId)
                .collect(Collectors.toSet());

        if(isComment) {
            log.info("处理评论中的目标用户");
            // 回复的目标用户是一个匿名用户
            final Long replyAnonyUserId = 0L;
            for (InteractionReplyEntity e : entities){
                Long targetUserId = e.getTargetUserId();
                if(!replyAnonyUserId.equals(targetUserId)){
                    // 只查询回复的目标非匿名的用户
                    userIds.add(targetUserId);
                }
            }
        }

        Map<Long, UserDetailEntity> mapUserEntities = userDetailDomainService.getMapEntities(userIds);

        List<ReplyResp> results = new ArrayList<>();
        for (InteractionReplyEntity e : entities) {
            ReplyResp target = Converter.INSTANCE.toTarget(e);
            // 匿名回答，不处理
            if (e.getAnonymity()) {
                log.info("匿名用户不进行处理 userId = {}", e.getUserId());
            } else {
                // 处理用户信息
                UserDetailEntity userDetailEntity = mapUserEntities.get(e.getUserId());
                ReplyUserResp replyUserResp = new ReplyUserResp();

                replyUserResp.setId(userDetailEntity.getId());
                replyUserResp.setName(userDetailEntity.getName());
                replyUserResp.setIcon(userDetailEntity.getIcon());

                target.setReplyUser(replyUserResp);
            }

            if(isComment){
                // 处理评论的目标用户
                UserDetailEntity userDetailEntity = mapUserEntities.get(e.getTargetUserId());
                if(userDetailEntity != null){
                    target.setTargetUserName(userDetailEntity.getName());
                }else{
                    log.info("该评论针对的是匿名用户");
                    target.setTargetUserName("匿名用户");
                }
            }
            results.add(target);
        }
        return results;
    }

    @Mapper
    interface Converter extends TargetAndSourceConverter<ReplyResp, InteractionReplyEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
