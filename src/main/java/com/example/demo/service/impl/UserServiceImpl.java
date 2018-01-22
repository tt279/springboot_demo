package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.PointService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PointService pointService;

    @Override
    public User findByName(String userName) {

        return userMapper.findByName(userName);
    }


    @Transactional
    @Override
    public int insert(String name, Integer age) throws Exception {
        //测试嵌套事务   pioint 应当插入成功，user回滚

        userMapper.insert("a", 20);

        pointService.insert(2L, 2L);

        if( age ==20 ){
            throw new RuntimeException();
        }
        userMapper.insert(name, age);

        return 1;
    }

}
