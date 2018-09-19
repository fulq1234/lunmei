package com.lunmei.demo2;

import com.lunmei.demo2.config.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo2ApplicationTests {


    @Autowired
    private MoveFactor moveFactor;


    @Test
    public void contextLoads() {
        System.out.println("ddd");
       moveFactor.speak();
    }

}
