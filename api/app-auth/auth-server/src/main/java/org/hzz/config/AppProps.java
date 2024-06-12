package org.hzz.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/12
 */
@Component
@ConfigurationProperties(prefix = "app")
@Setter
@Getter
public class AppProps {
    private String[] ignore_urls;
    private JWTProps jwt;


    @Setter
    @Getter
    public static class JWTProps {
        private String secretKey;
        private long expirationTime;
    }
 }
