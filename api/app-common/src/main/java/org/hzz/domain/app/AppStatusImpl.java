package org.hzz.domain.app;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/14
 */
public enum AppStatusImpl implements AppStatus{
    OK(2000,"成功"),
    NOT_FOUND(4000,"不存在"),
    EMAIL_ERROR(4001,"邮箱不存在"),
    PASSWORD_ERROR(4002,"密码不正确"),
    INTERNAL_ERROR(5000,"应用异常");

    private final int code;
    private final String reason;

    private AppStatusImpl(int code, String reason) {
        this.code = code;
        this.reason = reason;
    }

    @Override
    public int value() {
        return this.code;
    }


    @Override
    public String getReason() {
        return this.reason;
    }
}
