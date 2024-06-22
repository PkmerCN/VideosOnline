package org.hzz.auth.exception;

import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.AppCommonException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
public class PasswordException extends AppCommonException {
    public PasswordException(){
        super(AppStatusImpl.PASSWORD_ERROR);
    }
}
