package org.hzz.auth.config.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/22
 */
@Setter
@Getter
@ConfigurationProperties("app")
public class AppProps {
    private String[] ignore_urls;
}
