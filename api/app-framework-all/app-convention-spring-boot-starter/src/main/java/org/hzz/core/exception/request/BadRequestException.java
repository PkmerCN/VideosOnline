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
    private final AppStatus appStatus;

    public BadRequestException(){
        super(AppStatusImpl.NO_PERMISSION.getReason());
        this.appStatus = AppStatusImpl.NO_PERMISSION;
    }

    public BadRequestException(String message){
        super(message);
        this.appStatus = AppStatusImpl.NO_PERMISSION;
    }


    public BadRequestException(AppStatus appStatus){
        super(appStatus.getReason());
        this.appStatus = appStatus;
    }

    @Override
    public AppStatus getStatus() {
        return appStatus;
    }
}
