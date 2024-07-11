package org.hzz.learning.infrastructure.dao.entity.question;

import org.hzz.mybatis.annotation.SnowflakeId;

import java.time.LocalDateTime;

/**
 * generated by MyBatis Generator.
 * interaction_reply(互动问题的回答或评论) 
 * 
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/07/11
 */
public class InteractionReply {
    // 互动问题的回答id
    @SnowflakeId
    private Long id;

    // 互动问题问题id
    private Long questionId;

    // 回复的上级回答id
    private Long answerId;

    // 回答者id
    private Long userId;

    // 回答内容
    private String content;

    // 回复的目标用户id
    private Long targetUserId;

    // 回复的目标回复id
    private Long targetReplyId;

    // 评论数量
    private Integer replyTimes;

    // 点赞数量
    private Integer likedTimes;

    // 是否被隐藏，默认false
    private Boolean hidden;

    // 是否匿名，默认false
    private Boolean anonymity;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(Long targetUserId) {
        this.targetUserId = targetUserId;
    }

    public Long getTargetReplyId() {
        return targetReplyId;
    }

    public void setTargetReplyId(Long targetReplyId) {
        this.targetReplyId = targetReplyId;
    }

    public Integer getReplyTimes() {
        return replyTimes;
    }

    public void setReplyTimes(Integer replyTimes) {
        this.replyTimes = replyTimes;
    }

    public Integer getLikedTimes() {
        return likedTimes;
    }

    public void setLikedTimes(Integer likedTimes) {
        this.likedTimes = likedTimes;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Boolean getAnonymity() {
        return anonymity;
    }

    public void setAnonymity(Boolean anonymity) {
        this.anonymity = anonymity;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}