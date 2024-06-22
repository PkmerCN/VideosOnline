package org.hzz.user.domain.exception;

import org.hzz.core.code.impl.AppStatusImpl;
import org.hzz.core.exception.AppCommonException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
public class EmailException extends AppCommonException {
    public EmailException(){
        super(AppStatusImpl.EMAIL_ERROR);
    }
}
