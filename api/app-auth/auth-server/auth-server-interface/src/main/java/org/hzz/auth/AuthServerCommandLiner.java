package org.hzz.auth;


import lombok.extern.slf4j.Slf4j;
import org.hzz.auth.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class AuthServerCommandLiner implements CommandLineRunner, Ordered {

    @Autowired
    private TestRepository testRepository;

    @Override
    public void run(String... args){
        String result = testRepository.testConnection();
        if(result != null){
            log.info("auth-server connect {} success",result);
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}