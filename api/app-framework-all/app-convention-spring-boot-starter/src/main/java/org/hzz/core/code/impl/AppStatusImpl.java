package org.hzz.core.code.impl;

import org.hzz.core.code.AppStatus;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/14
 */
public enum AppStatusImpl implements AppStatus {
    OK(2000,"成功"),
    NOT_FOUND(4000,"不存在"),
    EMAIL_ERROR(4001,"邮箱不存在"),
    PASSWORD_ERROR(4002,"密码不正确"),
    TOKEN_EXPIRED(4003,"Token已过期"),
    TOKEN_INVALID(4004,"Token不合法"),
    ARG_INVALID(4005,"参数不合法"),
    NO_PERMISSION(4006,"没有权限"),
    REPEAT_OPERATION(4007,"重复操作"),
    NOT_ALLOW_100(4008,"只允许查询100条"),
    REPEAT_SIGN_OPERATION(4008,"重复签到"),
    INTERNAL_ERROR(5000,"应用异常"),
    DB_ERROR(5001,"数据库异常"),
    DB_ENTITY_NOT_FOUND(5002,"数据库不存在该数据"),
    DB_UPDATE_FAILD(5003,"更新异常"),
    DB_INSERT_FAILD(5004,"添加数据异常");

    private final int code;
    private final String reason;

    private AppStatusImpl(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    @Override
    public int code() {
        return this.code;
    }


    @Override
    public String getReason() {
        return this.reason;
    }
}
