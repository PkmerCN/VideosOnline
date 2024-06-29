package org.hzz.core.exception.db;

import org.hzz.core.code.AppStatus;
import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.AppCommonException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/29
 */
public class AppDbUpdateException extends AppCommonException {

    private final AppStatus appStatus = AppStatusImpl.DB_UPDATE_FAILD;
    public AppDbUpdateException(String message){
        super(message);
    }
}
