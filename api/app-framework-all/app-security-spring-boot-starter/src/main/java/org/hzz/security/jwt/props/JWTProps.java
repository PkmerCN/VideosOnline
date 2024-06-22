package org.hzz.security.jwt.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/21
 */
@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "app.jwt")
public class JWTProps {
    private String secretKey;
    private long expirationTime = 3600;
}
