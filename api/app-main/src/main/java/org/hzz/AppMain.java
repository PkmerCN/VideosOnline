package org.hzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class AppMain {

    @RequestMapping("/")
    String home(){
        return "Happy Coding!!2";
    }

    @RequestMapping("/test")
    String test(){
        return "test 胖卡..hello world m";
    }

    public static void main(String[] args) {
        SpringApplication.run(AppMain.class,args);
    }
}