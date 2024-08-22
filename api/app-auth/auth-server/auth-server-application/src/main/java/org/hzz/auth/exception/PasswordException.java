package org.hzz.auth.exception;

import io.gitee.pkmer.convention.code.impl.AppStatusImpl;
import io.gitee.pkmer.convention.exception.AppCommonException;

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
