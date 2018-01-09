package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

    User findByName(String userName);

    int insert(String name, Integer age);

}
