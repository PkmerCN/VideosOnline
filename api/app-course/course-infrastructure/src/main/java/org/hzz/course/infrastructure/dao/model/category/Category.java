package org.hzz.course.infrastructure.dao.model.category;

import java.time.LocalDateTime;
import org.hzz.core.enums.delete.Deleted;
import org.hzz.course.types.enums.CategoryLevel;
import org.hzz.course.types.enums.CategoryStatus;

/**
 * generated by MyBatis Generator.
 * category(课程分类)
 *
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/07/13
 */
public class Category {
    // 课程分类id
    private Long id;

    // 分类名称
    private String name;

    // 父分类id，一级分类父id为0
    private Long parentId;

    // 分类级别，1,2,3：代表一级分类，二级分类，三级分类
    private CategoryLevel level;

    // 同级目录优先级，数字越小优先级越高，可以重复
    private Integer priority;

    // 课程分类状态，1：正常，2：禁用
    private CategoryStatus status;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    // 创建者Id
    private Long createrId;

    // 更新者Id
    private Long updaterId;

    //
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public CategoryLevel getLevel() {
        return level;
    }

    public void setLevel(CategoryLevel level) {
        this.level = level;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public CategoryStatus getStatus() {
        return status;
    }

    public void setStatus(CategoryStatus status) {
        this.status = status;
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