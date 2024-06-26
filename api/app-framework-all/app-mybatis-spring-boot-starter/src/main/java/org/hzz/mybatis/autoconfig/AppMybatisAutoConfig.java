package org.hzz.mybatis.autoconfig;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hzz.mybatis.core.SnowflakeIdPlugin;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/6/27
 */
@ConditionalOnClass(SqlSessionFactory.class)
@Slf4j
public class AppMybatisAutoConfig {
    @Bean
    @ConditionalOnMissingBean
    public SnowflakeIdPlugin snowflakeIdPlugin(){
        log.info("自动注入SnowflakeIdPlugin插件");
        return new SnowflakeIdPlugin();
    }
}
