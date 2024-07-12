package org.hzz.core.exception.request;

import org.hzz.core.code.AppStatus;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.AppCommonException;

/**
 * 错误请求
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/12
 */
public class BadRequestException extends AppCommonException {
    private static final AppStatus appStatus = AppStatusImpl.NO_PERMISSION;

    public BadRequestException(){
        super(appStatus.getReason());
    }

    public BadRequestException(String message){
        super(message);
    }

    @Override
    public AppStatus getStatus() {
        return appStatus;
    }
}
