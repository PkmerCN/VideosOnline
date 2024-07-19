package com.hzz.generator;

import lombok.extern.slf4j.Slf4j;
import org.hzz.mybatis.generator.MyBatisGeneratorRunner;

import java.nio.file.FileSystems;

/**
 * 手动处理代码生成
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/18
 */
@Slf4j
public class AppMyBatisGen {

    /**
     * 在IDEA中配置workdingDirectory
     * 将生成代码存放到指定的工作目录
     * @param args
     */
    public static void main(String[] args){
        log.info("start");
        MyBatisGeneratorRunner.genCode();
        log.info("代码生成在 {}",getWorkingDirectory());
        log.info("End");
    }


    public static String getWorkingDirectory(){
        return FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
    }
}
