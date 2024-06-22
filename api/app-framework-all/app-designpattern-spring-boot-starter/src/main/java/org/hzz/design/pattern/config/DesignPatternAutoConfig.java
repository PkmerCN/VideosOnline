package org.hzz.design.pattern.config;

import org.hzz.design.pattern.strategy.StrategyChoose;
import org.hzz.springboot.starter.base.config.ApplicationBaseAutoConfiguration;
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
public class DesignPatternAutoConfig {
    private final Logger LOG = LoggerFactory.getLogger(DesignPatternAutoConfig.class);

    public DesignPatternAutoConfig(){
        LOG.info("检测到自动配置: DesignPatternAutoConfiguration");
    }

    @Bean
    @ConditionalOnMissingBean
    public StrategyChoose strategyChoose(){
        LOG.info("正在注册strategyChoose");
        return new StrategyChoose();
    }

}
