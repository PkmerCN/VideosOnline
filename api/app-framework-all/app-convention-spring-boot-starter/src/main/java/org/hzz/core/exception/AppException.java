package org.hzz.core.exception;


import org.hzz.core.code.AppStatus;

/**
 * 应用异常
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/14
 */
public interface AppException {
    AppStatus getStatus();
}
