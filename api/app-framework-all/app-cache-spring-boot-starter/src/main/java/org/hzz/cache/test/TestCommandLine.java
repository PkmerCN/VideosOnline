package org.hzz.cache.test;

import org.hzz.cache.core.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author 胖卡
 * @version 1.0.0
 * @date 2024/7/8
 */
@Component
public class TestCommandLine implements CommandLineRunner {

    @Autowired
    RedisCache redisCache;

    @Autowired
    @Lazy
    TestCommandLine self;
    @Override
    public void run(String... args) throws Exception {
        self.test();
    }

    public void test(){
        redisCache.setObject("redis:test","Hello Redis");
    }
}
