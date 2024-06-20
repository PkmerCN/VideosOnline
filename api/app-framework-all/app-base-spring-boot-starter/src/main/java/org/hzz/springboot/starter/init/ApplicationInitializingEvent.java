package org.hzz.springboot.starter.init;

import org.springframework.context.ApplicationEvent;

/**
 * 应用初始化事件
 * <p>规约事件，通过此事件可以查看业务系统所有初始化行为</p>
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public class ApplicationInitializingEvent extends ApplicationEvent {
    public ApplicationInitializingEvent(Object source) {
        super(source);
    }
}
