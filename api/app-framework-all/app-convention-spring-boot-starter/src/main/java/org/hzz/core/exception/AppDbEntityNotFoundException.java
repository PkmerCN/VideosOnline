package org.hzz.core.exception;

import org.hzz.core.code.AppStatus;
import org.hzz.core.code.impl.AppStatusImpl;

/**
 * 数据库不存在异常
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
public class AppDbEntityNotFoundException extends AppCommonException{
    final AppStatus status = AppStatusImpl.DB_ENTITY_NOT_FOUND;
    public AppDbEntityNotFoundException(String message){
        super(message);
    }

}
