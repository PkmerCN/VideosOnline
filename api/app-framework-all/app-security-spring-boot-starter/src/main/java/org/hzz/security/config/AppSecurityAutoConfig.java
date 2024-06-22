package org.hzz.security.config;

import org.hzz.security.jwt.service.JWTService;
import org.hzz.security.password.AppPasswordEncoder;
import org.hzz.security.password.BcryptPassword4j;
import org.hzz.security.jwt.props.JWTProps;
import org.hzz.springboot.starter.base.config.ApplicationBaseAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/21
 */
//@ImportAutoConfiguration({ApplicationBaseAutoConfiguration.class})
@EnableConfigurationProperties({JWTProps.class})
public class AppSecurityAutoConfig {
    private final Logger LOG = LoggerFactory.getLogger(AppSecurityAutoConfig.class);

    public AppSecurityAutoConfig(){
        LOG.info("检测到AppSecurityAutoConfig自动配置类");
    }
    @Bean
    @ConditionalOnMissingBean
    public AppPasswordEncoder bcryptPassword4j(){
        LOG.info("自动注入AppPasswordEncoder Success");
        return new BcryptPassword4j();
    }

    @Bean
    @ConditionalOnMissingBean
    public JWTService jwtService(JWTProps jwtProps){
        LOG.info("正在自动注入JWTService,使用JwtProps = {}",jwtProps.toString());
        return new JWTService(jwtProps);
    }

}
