package org.hzz.remark.infrastructure.dao.model.liked;

import java.time.LocalDateTime;

/**
 * generated by MyBatis Generator.
 * liked_record(点赞记录表) 
 * 
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/07/25
 */
public class LikedRecord {
    // 主键id
    private Long id;

    // 用户id
    private Long userId;

    // 点赞的业务id
    private Long bizId;

    // 点赞的业务类型
    private String bizType;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBizId() {
        return bizId;
    }

    public void setBizId(Long bizId) {
        this.bizId = bizId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
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