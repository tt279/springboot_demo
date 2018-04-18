package com.example.demo;

import com.example.demo.service.PointService;
import com.example.demo.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserService userService;
    @Autowired
    PointService pointService;
    @Autowired
    ConfigBean configBean;
    @Autowired
    Environment environment;

    private static Logger log = LogManager.getLogger(DemoApplicationTests.class);

    @Test
    public void test() throws Exception {

        log.info(configBean.getName());
        log.info(environment.getProperty("com.test.content"));
        log.info(environment.getProperty("com.mytest.content"));
        log.info("=====================START");

        try {
        //    userService.insert("a", 33);
        } catch (Exception e){
            e.printStackTrace();
        }

        log.info("=====================END");
    }

}
