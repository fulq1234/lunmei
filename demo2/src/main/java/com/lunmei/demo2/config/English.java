package com.lunmei.demo2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value="b")
public class English implements MoveFactor {
    @Override
    public void speak() {
        System.out.println("I am an English");
    }
}
