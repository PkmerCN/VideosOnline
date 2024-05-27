package org.hzz;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AuthServierCommandLiner implements CommandLineRunner {

    @Override
    public void run(String... args){
        System.out.println("Auth Servier on work.");
    }
}
