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
    /**
     * token 与xxl_job服务端配置一样
     * 如果xxl_job没有配置的token的话
     * 默认是default_token
     */
    private String accessToken = "default_token";

    /**
     * xxl_job web端访问http://ip:port/xxl-job-admin
     */
    private String adminAddresses;
    private Executor executor;

    public XxlJobProps(){
        log.info("XxlJobProps 生效");
    }

    @Data
    public static class Executor{
        /**
         * 执行器的名字，我们为spring应用名称
         */
        private String appname;
        /**
         * 日志文件，会存储到项目中的目录文件
         */
        private String logPath;
        private String address;
        private String ip;
        private Integer port;
        private Integer logRetentionDays;
    }
}
