package org.hzz.security.context;

import org.hzz.security.context.user.AppUserContextHolder;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
public class AppContextHolder {
    public static AppUserContextHolder userContextHolder = new AppUserContextHolder();
}
