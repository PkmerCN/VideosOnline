package org.hzz.core.exception.db;

import org.hzz.core.code.AppStatus;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.AppCommonException;

/**
 * 数据库错误
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
public class AppDbException extends AppCommonException {
    final AppStatus appStatus = AppStatusImpl.DB_ERROR;
    public AppDbException(String message){
        super(message);
    }

}
