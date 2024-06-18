package org.hzz.exceptions.auth;

import org.hzz.domain.app.AppStatusImpl;
import org.hzz.exceptions.AppCommonException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/18
 */
public class AppTokenExpireException extends AppCommonException {
    public AppTokenExpireException(){
        super(AppStatusImpl.TOKEN_EXPIRED);
    }
}
