package org.hzz.auth.config.web;

import org.hzz.auth.config.interceptor.JWTAuthenticationInterceptor;
import org.hzz.auth.config.props.AppProps;
import org.hzz.security.jwt.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@ImportAutoConfiguration({SecurityAutoConfiguration.class})
@EnableConfigurationProperties(AppProps.class)
public class WebConfig implements WebMvcConfigurer {
    private AppProps appProps;

    private JWTService jwtService;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTAuthenticationInterceptor(jwtService))
                .excludePathPatterns(appProps.getIgnore_urls())
                .order(1);
    }

}
