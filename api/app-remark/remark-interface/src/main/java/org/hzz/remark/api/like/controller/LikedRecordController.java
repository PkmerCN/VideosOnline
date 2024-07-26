package org.hzz.remark.api.like.controller;

import lombok.Setter;
import org.hzz.core.controller.BaseController;
import org.hzz.core.result.Result;
import org.hzz.remark.api.like.LikedRecordApi;
import org.hzz.remark.application.command.liked.CheckUserLikeBizIdCommand;
import org.hzz.remark.application.command.liked.LikedCommand;
import org.hzz.remark.application.service.RemarkCmdService;
import org.hzz.remark.req.LikedReq;
import org.hzz.security.context.AppContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Set;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/26
 */
@RestController
public class LikedRecordController
        extends BaseController
        implements LikedRecordApi {

    @Setter(onMethod_ = @Autowired)
    private RemarkCmdService cmdService;


    /**
     * {@inheritDoc}
     *
     * @param likedReq 点赞请求
     */
    @Override
    public void handleLiked(LikedReq likedReq) {
        logger.info("点赞");
        LikedCommand cmd = new LikedCommand();
        cmd.setLiked(likedReq.getLiked())
                .setBizId(likedReq.getBizId())
                .setBizType(likedReq.getBizType())
                .setUserId(AppContextHolder.userContextHolder.getUser().getId());
        cmdService.handleCommand(cmd);
    }

    /**
     * @param bizIds 业务id集合
     */
    @Override
    public Result<Set<Long>> isBizLiked(Set<Long> bizIds) {

        logger.info("查询校验用户对业务的点赞情况");

        if (bizIds.isEmpty()) {
            return success(Collections.emptySet());
        }

        CheckUserLikeBizIdCommand cmd = new CheckUserLikeBizIdCommand();
        cmd.setBizIds(bizIds)
                .setUserId(AppContextHolder.userContextHolder.getUser().getId());

        Set<Long> o = cmdService.<Set<Long>>handleCommandWithResult(cmd);
        return success(o);
    }
}
