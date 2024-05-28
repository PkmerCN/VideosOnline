package org.hzz.info;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 打印APP信息
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/5/28
 */
@Component
public class AppInfo implements CommandLineRunner, Ordered {

    @Override
    public void run(String... args) throws Exception {
        ClassPathResource classPathResource = new ClassPathResource("info.txt");
        // file:/D:/gitee/challenges/videos-online/api/app-main/target/classes/info.txt
        Path path = Paths.get(classPathResource.getURI());
        String contents = Files.readString(path);
        System.out.println(contents);
    }

    @Override
    public int getOrder() {
        return 1000;
    }
}
