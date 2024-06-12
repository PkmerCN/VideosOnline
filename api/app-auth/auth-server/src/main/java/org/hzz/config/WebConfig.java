package org.hzz.config;

import org.hzz.interceptor.JWTAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/12
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AppProps appProps;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTAuthenticationInterceptor())
                .excludePathPatterns(appProps.getIgnore_urls())
                .order(1);
    }
}
