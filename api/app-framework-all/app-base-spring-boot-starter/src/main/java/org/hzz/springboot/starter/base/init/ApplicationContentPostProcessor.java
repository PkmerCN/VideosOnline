package org.hzz.springboot.starter.base.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.EventListener;

/**
 * 应用初始化后置处理器，防止Spring事件被多次执行
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public class ApplicationContentPostProcessor implements ApplicationContextAware {
    private final Logger LOG = LoggerFactory.getLogger(ApplicationContentPostProcessor.class);
    private ApplicationContext applicationContext;
    /**
     * 执行标识，确保Spring事件 {@link ApplicationReadyEvent} 有且执行一次
     */
    private volatile boolean executed = false;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;

    }

    /**
     * 监听springboot启动初始化事件，然后发布自己的事件
     * @param event
     */
    @EventListener
    public synchronized void handleApplicationReadyEvent(ApplicationReadyEvent event){
        if(!executed){
            LOG.info("监听到ApplicationReadyEvent，准备发布自定义的事件ApplicationInitializingEvent");
            applicationContext.publishEvent(new ApplicationInitializingEvent(this));
            executed = true;
        }
    }
}
