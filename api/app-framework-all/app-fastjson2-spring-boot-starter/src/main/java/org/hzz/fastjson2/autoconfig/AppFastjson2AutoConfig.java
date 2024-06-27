package org.hzz.fastjson2.autoconfig;

import org.hzz.fastjson2.converter.JsonMessageConverterConfigurer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * fastjson2集成，自动配置
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/28
 */
public class AppFastjson2AutoConfig {

    @Bean
    @ConditionalOnMissingBean
    public JsonMessageConverterConfigurer jsonMessageConverterConfigurer(){
        return new JsonMessageConverterConfigurer();
    }
}
