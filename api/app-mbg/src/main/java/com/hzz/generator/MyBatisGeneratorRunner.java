package com.hzz.generator;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 手动处理代码生成
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/18
 */
@Slf4j
public class MyBatisGeneratorRunner {
    public static void main(String[] args){
        log.info("start");
        try{
            ClassPathResource resource = new ClassPathResource("generatorConfig.xml");
            File configFile = resource.getFile();

            List<String> warnings = new ArrayList<>();

            ConfigurationParser cfgParser = new ConfigurationParser(warnings);
            Configuration configuration = cfgParser.parseConfiguration(configFile);
            // 是否覆盖已有文件
            boolean overwrite = true;
            // 创建默认的 ShellCallback 实现
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);

            // 创建 MyBatisGenerator 对象
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warnings);

            // 执行代码生成
            myBatisGenerator.generate(null);
            // 打印警告信息
            for (String warning : warnings) {
                System.out.println(warning);
            }

            System.out.println("Code generation completed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Code generation failed.");
        }
        log.info("End");
    }
}
