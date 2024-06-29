package org.hzz.core.exception.arg;

import jakarta.validation.ConstraintViolation;
import lombok.Getter;
import org.hzz.core.code.AppStatus;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.AppException;

import java.util.Set;

/**
 * 手动参数校验异常
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/30
 */
public class AppArgumentNotValidException extends RuntimeException implements AppException {
    private final AppStatus appStatus;

    @Getter
    private final Set<? extends ConstraintViolation<?>> constraintViolationSet;

    public <T> AppArgumentNotValidException(Set<ConstraintViolation<T>> constraintViolationSet){
        super(AppStatusImpl.ARG_INVALID.getReason());
        this.constraintViolationSet = constraintViolationSet;
        this.appStatus = AppStatusImpl.ARG_INVALID;
    }

    @Override
    public AppStatus getStatus() {
        return appStatus;
    }
}
