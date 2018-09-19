package com.lunmei.demo2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(value = "a")
public class Chinese implements MoveFactor {
    @Override
    public void speak() {
        System.out.println("我是中国人");
    }
}
