package org.hzz.user.domain.entity;

import lombok.Data;
import org.hzz.ddd.core.domain.shared.Entity;
import org.hzz.user.types.enums.Gender;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户详情实体
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
@Data
public class UserDetailEntity implements Entity {
    // 关联用户id
    private Long id;

    // 用户类型：1-员工, 2-普通学员，3-老师
    private Byte type;

    // 名字
    private String name;

    // 性别：0-男性，1-女性
    private Gender gender;

    // 头像地址
    private String icon;

    // 邮箱
    private String email;

    // QQ号码
    private String qq;

    // 生日
    private LocalDate birthday;

    // 岗位
    private String job;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String district;

    // 个人介绍
    private String intro;

    // 形象照地址
    private String photo;

    // 角色id
    private Long roleId;

    // 购买课程数量，学生才有该字段信息
    private Short courseAmount;

    // 创建时间
    private LocalDateTime createTime;

    // 更新时间
    private LocalDateTime updateTime;

    // 创建者id
    private Long creater;

    // 更新者id
    private Long updater;

    // 部门id
    private Long depId;
}
