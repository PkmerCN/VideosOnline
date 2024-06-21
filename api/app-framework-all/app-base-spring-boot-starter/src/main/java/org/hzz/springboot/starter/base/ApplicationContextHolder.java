package org.hzz.springboot.starter.base;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * Application Context Holder
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/21
 */
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CONTEXT = applicationContext;
    }

    public static <T> T getBean(Class<T> requiredType){
        return CONTEXT.getBean(requiredType);
    }

    public static <T> T getBean(String beanName,Class<T> requiredType){
        return CONTEXT.getBean(beanName,requiredType);
    }

    /**
     * Get a set of ioc container beans by type.
     * @param type
     * @return
     * @param <T>
     */
    public static <T> Map<String,T> getBeansOfType(Class<T> type){
        return CONTEXT.getBeansOfType(type);
    }


    public static ApplicationContext getInstance(){
        return CONTEXT;
    }


}
