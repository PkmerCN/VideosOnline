package org.hzz.scheduler.xxljob;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * xxl_job 配置
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/8/1
 */
@Slf4j
@Data
@ConfigurationProperties("xxl.job")
public class XxlJobProps {
    private String accessToken;
    private String adminAddresses;
    private Executor executor;

    public XxlJobProps(){
        log.info("XxlJobProps 生效");
    }

    @Data
    public static class Executor{
        private String appname;
        private String logPath;
        private String address;
        private String ip;
        private Integer port;
        private Integer logRetentionDays;
    }
}
