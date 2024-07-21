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

    /**
     * {
     * 	"code": 2000,
     * 	"msg": "成功",
     * 	"data": {
     * 		"currentPageNo": 1,
     * 		"list": [
     * 			            {
     * 				"anonymity": true,
     * 				"content": "评论用户的评论: Java 17DJK",
     * 				"createTime": "2024-07-17 07:51:50",
     * 				"hidden": false,
     * 				"id": 7219247414723612672,
     * 				"likedTimes": 0,
     * 				"replyTimes": 0,
     * 				"replyUser": {
     * 					"icon": "/img-tx/1.jpg",
     * 					"id": 1,
     * 					"name": "壮哥"
     *                },
     * 				"targetUserName": "匿名用户"
     *            },
     *            {
     * 				"anonymity": false,
     * 				"content": "评论回复 Love Java yeah",
     * 				"createTime": "2024-07-17 07:41:08",
     * 				"hidden": false,
     * 				"id": 7219244721317744640,
     * 				"likedTimes": 0,
     * 				"replyTimes": 0,
     * 				"replyUser": {
     * 					"icon": "/img-tx/3.jpg",
     * 					"id": 3,
     * 					"name": "胖卡"
     *                },
     * 				"targetUserName": "壮哥"
     *            }
     * 		],
     * 		"total": 2,
     * 		"totalPages": 1
     * 	}
     * }
     */
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
                    command.isComment(),
                    command.getForAdmin());
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
                    command.getForAdmin(),
                    command.getPageQuery()
            );
        } else {
            log.info("分页查询回答");
            pageEntities = replyDomainService.selectReplyPage(
                    command.getQuestionId(),
                    command.getForAdmin(),
                    command.getPageQuery()
            );
        }

        return pageEntities;
    }

    /**
     * 处理用户信息
     *
     * @param entities 具体数据
     * @param isComment true 评论；false 回复
     * @param isForAdmin true admin端处理，false 用户端处理
     */
    public List<ReplyResp> handleUserInfo(List<InteractionReplyEntity> entities,
                                          boolean isComment,
                                          boolean isForAdmin) {

        // 收集回答用户id
        Set<Long> userIds = entities.stream().map(InteractionReplyEntity::getUserId)
                .collect(Collectors.toSet());

        if(isComment) {
            log.info("处理评论中的目标用户");
            // 回复的目标用户是一个匿名用户
            Set<Long> targetUserIds = getTargetUserIds(entities);
            userIds.addAll(targetUserIds);
        }

        Map<Long, UserDetailEntity> mapUserEntities = userDetailDomainService.getMapEntities(userIds);

        List<ReplyResp> results = new ArrayList<>();
        for (InteractionReplyEntity e : entities) {
            ReplyResp target = Converter.INSTANCE.toTarget(e);
            // 用户端匿名回答，不处理。只处理非匿名回答或者是admin的查询
            if (e.getAnonymity() && !isForAdmin) {
                log.info("匿名用户用户端不进行处理 userId = {}", e.getUserId());
            } else {
                // 处理用户信息
                handleUserInfo(e,target,mapUserEntities);
            }

            if(isComment){
                // 处理评论的目标用户
                handleTargetUser(e,target,mapUserEntities);
            }
            results.add(target);
        }
        return results;
    }


    private Set<Long> getTargetUserIds(List<InteractionReplyEntity> entities){
        Set<Long> targetUserIds = new HashSet<>();
        final Long replyAnonyUserId = 0L;
        for (InteractionReplyEntity e : entities){
            Long targetUserId = e.getTargetUserId();
            if(!replyAnonyUserId.equals(targetUserId)){
                // 只查询回复的目标非匿名的用户
                targetUserIds.add(targetUserId);
            }
        }
        return targetUserIds;
    }


    /**
     * 处理评论或者回复的用户信息
     */
    private void handleUserInfo(InteractionReplyEntity e,
                               ReplyResp target,
                               Map<Long, UserDetailEntity> mapUserEntities){
        UserDetailEntity userDetailEntity = mapUserEntities.get(e.getUserId());
        ReplyUserResp replyUserResp = new ReplyUserResp();

        replyUserResp.setId(userDetailEntity.getId());
        replyUserResp.setName(userDetailEntity.getName());
        replyUserResp.setIcon(userDetailEntity.getIcon());

        target.setReplyUser(replyUserResp);
    }

    /**
     * 处理评论的目标用户
     */
    private void handleTargetUser(InteractionReplyEntity e,
                                  ReplyResp target,
                                  Map<Long, UserDetailEntity> mapUserEntities){
        UserDetailEntity userDetailEntity = mapUserEntities.get(e.getTargetUserId());
        if(userDetailEntity != null){
            target.setTargetUserName(userDetailEntity.getName());
        }else{
            log.info("该评论针对的是匿名用户");
            target.setTargetUserName("匿名用户");
        }
    }


    @Mapper
    interface Converter extends TargetAndSourceConverter<ReplyResp, InteractionReplyEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
