package org.hzz.exceptions.auth;

import org.hzz.domain.app.AppStatusImpl;
import org.hzz.exceptions.AppCommonException;

/**
 * TO
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/18
 */
public class AppTokenInvalidException extends AppCommonException {
    public AppTokenInvalidException(){
        super(AppStatusImpl.TOKEN_INVALID);
    }
}
