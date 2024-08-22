package org.hzz.user.domain.exception;

import io.gitee.pkmer.convention.code.impl.AppStatusImpl;
import io.gitee.pkmer.convention.exception.AppCommonException;

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
