package org.hzz.user.application.service;

import org.hzz.user.application.resp.UserLoginRespDTO;
import org.hzz.user.domain.command.UserLoginCommand;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/19
 */
public interface UserService {
    UserLoginRespDTO login(UserLoginCommand command);

//    class EmailException extends AppCommonException{
//        public EmailException(){
//            super(AppStatusImpl.EMAIL_ERROR);
//        }
//    }
//
//    class PasswordException extends AppCommonException{
//        public PasswordException(){
//            super(AppStatusImpl.PASSWORD_ERROR);
//        }
//    }
}
