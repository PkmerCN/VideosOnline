package org.hzz.core.exception;

import org.hzz.core.code.AppStatus;
import org.hzz.core.code.impl.AppStatusImpl;

/**
 * 数据库错误
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
public class AppDbException extends AppCommonException{
    final AppStatus status = AppStatusImpl.DB_ERROR;
    public AppDbException(String message){
        super(message);
    }

}
