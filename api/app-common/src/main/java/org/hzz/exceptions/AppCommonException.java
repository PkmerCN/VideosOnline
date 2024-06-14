package org.hzz.exceptions;

import org.hzz.domain.app.AppStatus;
import org.hzz.domain.app.AppStatusImpl;

/**
 * 系统异 常
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/14
 */
public class AppCommonException extends RuntimeException implements AppException{

    private AppStatus appStatus;

    public AppCommonException(){
        super();
        appStatus = AppStatusImpl.INTERNAL_ERROR;
    }

    public AppCommonException(String messsage){
        super(messsage);
        appStatus = AppStatusImpl.INTERNAL_ERROR;
    }

    public AppCommonException(AppStatus appStatus){
        super(appStatus.getReason());
        this.appStatus = appStatus;
    }

    @Override
    public AppStatus getStatus() {
        return appStatus;
    }
}
