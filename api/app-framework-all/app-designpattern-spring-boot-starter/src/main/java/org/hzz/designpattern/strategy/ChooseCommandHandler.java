package org.hzz.designpattern.strategy;

import org.hzz.springboot.starter.init.ApplicationInitializingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public class ChooseCommandHandler implements ApplicationListener<ApplicationInitializingEvent> {
    @Override
    public void onApplicationEvent(ApplicationInitializingEvent event) {

    }
}
