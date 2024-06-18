package org.hzz.context;

import org.hzz.context.user.AppUserContextHolder;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/18
 */
public class AppContextHolder {
    public static AppUserContextHolder userContextHolder = new AppUserContextHolder();
}
