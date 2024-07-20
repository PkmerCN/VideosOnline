package org.hzz.learning.application.handler.reply;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hzz.common.collection.CollUtil;
import org.hzz.common.tree.BaseConverter;
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
 * 分页查询
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
        return null;
    }

    @Override
    public PageResponse<ReplyResp> executeWithResp(PageQueryReplyCommand command) {
        // 分页
        PageResponse<InteractionReplyEntity> pageEntities = replyDomainService.selectReplyPage(command.getQuestionId(), command.getPageQuery());
        // 直接转化
        PageResponse<ReplyResp> pageResp = Converter.INSTANCE.convertToTargetPage(pageEntities);

        List<InteractionReplyEntity> entities = pageEntities.getList();

        if(CollUtil.isEmpty(entities)){
            pageResp.setList(Collections.emptyList());
            return pageResp;
        }else{
            List<ReplyResp> replyResp = handleUserInfo(entities);
            pageResp.setList(replyResp);
        }

        return pageResp;
    }

    /**
     * 处理用户信息
     * @param entities 具体数据
     */
    public List<ReplyResp> handleUserInfo(List<InteractionReplyEntity> entities){
        // 收集回答用户id
        Set<Long> userIds = entities.stream().map(InteractionReplyEntity::getUserId)
                .collect(Collectors.toSet());

        Map<Long, UserDetailEntity> mapEntities = userDetailDomainService.getMapEntities(userIds);


        List<ReplyResp> results = new ArrayList<>();
        for (InteractionReplyEntity e: entities){
            ReplyResp target = Converter.INSTANCE.toTarget(e);
            // 匿名回答，不处理
            if(e.getAnonymity()){
                log.info("匿名用户不进行处理 userId = {}",e.getUserId());
            }else{
                // 处理用户信息
                UserDetailEntity userDetailEntity = mapEntities.get(e.getUserId());
                ReplyUserResp replyUserResp = new ReplyUserResp();

                replyUserResp.setId(userDetailEntity.getId());
                replyUserResp.setName(userDetailEntity.getName());
                replyUserResp.setIcon(userDetailEntity.getIcon());

                target.setReplyUser(replyUserResp);
            }

            results.add(target);
        }

        return results;
    }

    @Mapper
    interface Converter extends TargetAndSourceConverter<ReplyResp,InteractionReplyEntity> {
        Converter INSTANCE = Mappers.getMapper(Converter.class);
    }
}
