package org.hzz.springboot.starter.config;

import org.hzz.springboot.starter.init.ApplicationContentPostProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
public class ApplicationBaseAutoConfiguration {
    private final Logger LOG = LoggerFactory.getLogger(ApplicationBaseAutoConfiguration.class);

    public ApplicationBaseAutoConfiguration(){
        LOG.info("检测到ApplicationBaseAutoConfiguration自动配置");
    }

    @Bean
    @ConditionalOnMissingBean
    public ApplicationContentPostProcessor applicationContentPostProcessor(){
        return new ApplicationContentPostProcessor();
    }
}
