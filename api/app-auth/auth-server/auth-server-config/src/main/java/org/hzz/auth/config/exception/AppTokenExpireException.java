package org.hzz.auth.config.exception;

import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.AppCommonException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
public class AppTokenExpireException extends AppCommonException {
    public AppTokenExpireException(){
        super(AppStatusImpl.TOKEN_EXPIRED);
    }
}
