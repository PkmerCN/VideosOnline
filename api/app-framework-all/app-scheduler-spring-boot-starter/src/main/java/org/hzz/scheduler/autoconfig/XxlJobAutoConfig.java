package org.hzz.scheduler.autoconfig;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.hzz.scheduler.xxljob.XxlJobProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@AutoConfiguration
@ConditionalOnClass(XxlJobSpringExecutor.class)
@EnableConfigurationProperties(XxlJobProps.class)
public class XxlJobAutoConfig {
    private static final Logger log = LoggerFactory.getLogger(XxlJobAutoConfig.class);
    
    @Bean
    public XxlJobSpringExecutor xxlJobExecutor(XxlJobProps props) {
        log.info(">>>>>>>>>>> xxl-job config init.");
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        String adminAddresses = props.getAdminAddresses();
        if (adminAddresses != null && !adminAddresses.isBlank()) {
            xxlJobSpringExecutor.setAdminAddresses(adminAddresses);
        }
        XxlJobProps.Executor executor = props.getExecutor();
        if (executor != null) {
            if (executor.getAppname() != null)
                xxlJobSpringExecutor.setAppname(executor.getAppname());
            if (executor.getIp() != null)
                xxlJobSpringExecutor.setIp(executor.getIp());
            if (executor.getPort() != null)
                xxlJobSpringExecutor.setPort(executor.getPort());
            if (executor.getLogPath() != null)
                xxlJobSpringExecutor.setLogPath(executor.getLogPath());
            if (executor.getLogRetentionDays() != null)
                xxlJobSpringExecutor.setLogRetentionDays(executor.getLogRetentionDays());
        }
        if (props.getAccessToken() != null)
            xxlJobSpringExecutor.setAccessToken(props.getAccessToken());
        log.info(">>>>>>>>>>> xxl-job config end.");
        return xxlJobSpringExecutor;
    }
}
