package org.hzz.aop.autoconfig;

import org.hzz.aop.aspectj.AddUserIdFilterConditionAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * 自定义aop自动配置类
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
public class AppAopAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public AddUserIdFilterConditionAspect addUserIdFilterConditionAspect(){
        return new AddUserIdFilterConditionAspect();
    }
}
