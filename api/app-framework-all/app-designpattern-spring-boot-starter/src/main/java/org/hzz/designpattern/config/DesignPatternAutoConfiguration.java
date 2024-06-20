package org.hzz.designpattern.config;

import org.hzz.designpattern.strategy.ChooseCommandHandler;
import org.hzz.springboot.starter.config.ApplicationBaseAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * 设计模式自动装配
 * 依赖 {@link ApplicationBaseAutoConfiguration}
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/20
 */
@ImportAutoConfiguration(ApplicationBaseAutoConfiguration.class)
public class DesignPatternAutoConfiguration {
    private final Logger LOG = LoggerFactory.getLogger(DesignPatternAutoConfiguration.class);

    public DesignPatternAutoConfiguration(){
        LOG.info("检测到自动配置: DesignPatternAutoConfiguration");
    }

    @Bean
    @ConditionalOnMissingBean
    public ChooseCommandHandler chooseCommandHandler(){
        return new ChooseCommandHandler();
    }

}
