package org.hzz.learning.infrastructure.dao.entity.lesson;

import org.hzz.mybatis.annotation.SnowflakeId;

import java.time.LocalDateTime;

/**
 * generated by MyBatis Generator.
 * learning_lesson(学生学习课程表) 
 * 
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/06/29
 */
public class LearningLesson {
    // 主键
    @SnowflakeId
    private Long id;

    // 学员id
    private Long userId;

    // 课程id
    private Long courseId;

    // 课程状态，0-未学习，1-学习中，2-已学完，3-已失效
    private Byte status;

    // 每周学习频率，例如每周学习6小节，则频率为6
    private Byte weekFreq;

    // 学习计划状态，0-没有计划，1-计划进行中
    private Byte planStatus;

    // 已学习小节数量
    private Integer learnedSections;

    // 最近一次学习的小节id
    private Long latestSectionId;

    // 最近一次学习的时间
    private LocalDateTime latestLearnTime;

    // 创建时间
    private LocalDateTime createTime;

    // 过期时间
    private LocalDateTime expireTime;

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

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getWeekFreq() {
        return weekFreq;
    }

    public void setWeekFreq(Byte weekFreq) {
        this.weekFreq = weekFreq;
    }

    public Byte getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(Byte planStatus) {
        this.planStatus = planStatus;
    }

    public Integer getLearnedSections() {
        return learnedSections;
    }

    public void setLearnedSections(Integer learnedSections) {
        this.learnedSections = learnedSections;
    }

    public Long getLatestSectionId() {
        return latestSectionId;
    }

    public void setLatestSectionId(Long latestSectionId) {
        this.latestSectionId = latestSectionId;
    }

    public LocalDateTime getLatestLearnTime() {
        return latestLearnTime;
    }

    public void setLatestLearnTime(LocalDateTime latestLearnTime) {
        this.latestLearnTime = latestLearnTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}