package com.example.demo.controller;

import com.example.demo.ConfigBean;
import com.example.demo.model.User;
import com.example.demo.service.TestService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Scope(value = "prototype" , proxyMode = ScopedProxyMode.TARGET_CLASS)
// /@RestController注解能够使项目支持Rest
@RestController
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot")
public class UserController {

    @Autowired
    ConfigBean configBean;
    @Autowired
    UserService userService;
    @Autowired
    TestService testService;

    @Value("${com.test.name}")
    private  String name;
    @Value("${com.test.content}")
    private  String content;

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/getUserByGet")
    Map<String, Object> getUserByGet(@RequestParam(value = "userName") String userName)
            throws JsonProcessingException {
        User u = userService.findByName(userName);
        System.out.println(userService);
        System.out.println(userService);

        Map<String, Object> map = new HashMap<>(10);
        map.put("name", configBean.getName());
        map.put("content", content);
        map.put("userName", userName);
        //map.put("user", u);

        //System.out.println(Thread.currentThread().getContextClassLoader().toString());
        System.out.println(userService.getClass().getClassLoader().toString());
        System.out.println(Thread.currentThread().getName().toString());


        return map;
    }


    @RequestMapping(value = "/test")
    Map<String, Object> test()
            throws JsonProcessingException {
        System.out.println("statr di=================");
        System.out.println("controller:" + this);
        System.out.println("controller:" + this);
        System.out.println("controller:" + this);

        System.out.println("controller:" + testService);
        System.out.println("controller:" + testService);

        testService.test();

        Map<String, Object> map = new HashMap<>(16);
        map.put("name", "lll");

        try {
            userService.insert("kk",2);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }


    @RequestMapping(value = "/testScan")
    Map<String, Object> testScan()
            throws JsonProcessingException {

        testService.testScan();

        Map<String, Object> map = new HashMap<>(16);
        map.put("testScan", "testScan");

        return map;
    }

}