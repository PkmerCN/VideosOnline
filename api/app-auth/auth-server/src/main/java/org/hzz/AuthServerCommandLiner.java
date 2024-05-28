package org.hzz;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class AuthServerCommandLiner implements CommandLineRunner, Ordered {

    @Override
    public void run(String... args){
        log.info("Auth Server on work2");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
