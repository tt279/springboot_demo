package com.example.demo.controller;

import com.example.demo.ConfigBean;
import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController注解能够使项目支持Rest
@RestController
//表示该controller类下所有的方法都公用的一级上下文根
@RequestMapping(value = "/springboot")
public class UserController {

    @Autowired
    ConfigBean configBean;
    @Autowired
    UserService userService;


    @Value("${com.test.name}")
    private  String name;
    @Value("${com.test.content}")
    private  String content;

    //这里使用@RequestMapping注解表示该方法对应的二级上下文路径
    @RequestMapping(value = "/getUserByGet")
    Map<String, Object> getUserByGet(@RequestParam(value = "userName") String userName)
            throws JsonProcessingException {
        User u = userService.findByName(userName);

        Map<String, Object> map = new HashMap<>(10);
        map.put("name", configBean.getName());
        map.put("content", content);
        map.put("userName", userName);
        map.put("user", u);

        return map;
    }

}