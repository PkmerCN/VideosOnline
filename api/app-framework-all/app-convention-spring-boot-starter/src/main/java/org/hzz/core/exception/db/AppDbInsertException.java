package org.hzz.core.exception.db;

import org.hzz.core.code.AppStatus;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.AppCommonException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
public class AppDbInsertException extends AppCommonException {

    final AppStatus appStatus = AppStatusImpl.DB_INSERT_FAILD;
    public AppDbInsertException(String message){
            super(message);
    }
}
