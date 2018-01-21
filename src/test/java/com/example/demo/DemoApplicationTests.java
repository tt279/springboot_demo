package com.example.demo;

import com.example.demo.service.PointService;
import com.example.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    PointService pointService;

    @Test
    public void test() throws Exception {

        System.out.println("=====================START");
        try {
            userService.insert("b", 20);
        } catch (Exception e){
            e.printStackTrace();
        }

        System.out.println("=====================END");
    }

}
