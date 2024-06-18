package org.hzz.services;

import org.hzz.domain.app.AppStatusImpl;
import org.hzz.domain.user.bo.UserBo;
import org.hzz.exceptions.AppCommonException;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/13
 */
public interface AppUserService {
    UserBo getUserByEmailAndPassword(String email, String password);

    class EmailException extends AppCommonException{
        public EmailException(){
            super(AppStatusImpl.EMAIL_ERROR);
        }
    }

    class PasswordException extends AppCommonException{
        public PasswordException(){
            super(AppStatusImpl.PASSWORD_ERROR);
        }
    }
}
