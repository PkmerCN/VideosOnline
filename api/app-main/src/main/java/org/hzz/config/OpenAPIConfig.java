package org.hzz.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/28
 */
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI(
            @Value("${app-version}") String version
    ) {
        final String desc = "<div class='desc-container'>\uD83D\uDD25\uD83D\uDE0A<span class='desc'>This is a project that I use for full-stack development</span>\uD83D\uDE0A\uD83D\uDD25</div>";
        return new OpenAPI()
                .info(new Info()
                        .title("Pkmer Videos Online Project OpenAPI")
                        .version(version)
                        .description(desc)
                        .contact(new Contact().name("卡卡").email("1193094618@qq.com").url("https://pkmer.gitee.io"))
                        .license(new License().name("Apache 2.0")));

    }
}
