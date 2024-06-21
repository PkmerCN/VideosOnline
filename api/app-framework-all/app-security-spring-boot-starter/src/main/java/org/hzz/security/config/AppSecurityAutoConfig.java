package org.hzz.security.config;

import org.hzz.security.password.AppPasswordEncoder;
import org.hzz.security.password.BcryptPassword4j;
import org.hzz.security.jwt.props.JWTProps;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/21
 */
@EnableConfigurationProperties(JWTProps.class)
public class AppSecurityAutoConfig {
    @Bean
    @ConditionalOnMissingBean
    public AppPasswordEncoder bcryptPassword4j(){
        return new BcryptPassword4j();
    }
}
