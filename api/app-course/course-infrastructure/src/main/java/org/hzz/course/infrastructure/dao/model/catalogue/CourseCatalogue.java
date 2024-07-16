package org.hzz.course.infrastructure.dao.model.catalogue;

import org.hzz.core.enums.delete.Deleted;
import org.hzz.course.types.enums.catalogue.CatalogueType;
import org.hzz.course.types.enums.catalogue.TrailerType;

import java.time.LocalDateTime;

/**
 * generated by MyBatis Generator.
 * course_catalogue(课程录草稿) 
 * 
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/07/16
 */
public class CourseCatalogue {
    // 课程目录id
    private Long id;

    // 目录名称
    private String name;

    // 是否支持试看
    private TrailerType trailer;

    // 课程id
    private Long courseId;

    // 目录类型1：章，2：节，3：测试
    private CatalogueType type;

    // 所属章id，只有小节和测试有该值，章没有，章默认为0
    private Long parentCatalogueId;

    // 媒资id
    private Long mediaId;

    // 视频id
    private Long videoId;

    // 视频名称
    private String videoName;

    // 直播开始时间
    private LocalDateTime livingStartTime;

    // 直播结束时间
    private LocalDateTime livingEndTime;

    // 是否支持回放
    private Byte playBack;

    // 视频时长，以秒为单位
    private Integer mediaDuration;

    // 用于章节排序
    private Integer cIndex;

    // 部门id
    private Long depId;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    // 创建人Id
    private Long createrId;

    // 更新人Id
    private Long updaterId;

    // 逻辑删除
    private Deleted deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TrailerType getTrailer() {
        return trailer;
    }

    public void setTrailer(TrailerType trailer) {
        this.trailer = trailer;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public CatalogueType getType() {
        return type;
    }

    public void setType(CatalogueType type) {
        this.type = type;
    }

    public Long getParentCatalogueId() {
        return parentCatalogueId;
    }

    public void setParentCatalogueId(Long parentCatalogueId) {
        this.parentCatalogueId = parentCatalogueId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public LocalDateTime getLivingStartTime() {
        return livingStartTime;
    }

    public void setLivingStartTime(LocalDateTime livingStartTime) {
        this.livingStartTime = livingStartTime;
    }

    public LocalDateTime getLivingEndTime() {
        return livingEndTime;
    }

    public void setLivingEndTime(LocalDateTime livingEndTime) {
        this.livingEndTime = livingEndTime;
    }

    public Byte getPlayBack() {
        return playBack;
    }

    public void setPlayBack(Byte playBack) {
        this.playBack = playBack;
    }

    public Integer getMediaDuration() {
        return mediaDuration;
    }

    public void setMediaDuration(Integer mediaDuration) {
        this.mediaDuration = mediaDuration;
    }

    public Integer getcIndex() {
        return cIndex;
    }

    public void setcIndex(Integer cIndex) {
        this.cIndex = cIndex;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
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

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public Long getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    public Deleted getDeleted() {
        return deleted;
    }

    public void setDeleted(Deleted deleted) {
        this.deleted = deleted;
    }
}