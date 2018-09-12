package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.PointService;
import com.example.demo.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
//@Scope(value = "prototype" , proxyMode = ScopedProxyMode.DEFAULT)
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
        System.out.println(AopContext.currentProxy().hashCode());
        System.out.println(TransactionAspectSupport.currentTransactionStatus().hasSavepoint());

        userMapper.insert("a", 20);

        try {
            pointService.insert(2L, 2L);
        } catch (Exception e){
            System.out.println(TransactionAspectSupport.currentTransactionStatus().isRollbackOnly());
            e.printStackTrace();
        }

      /*  if( age ==20 ){
            throw new RuntimeException();
        }*/
     //   userMapper.insert(name, age);

        return 1;
    }

/*
    @Autowired
    public UserServiceImpl(PointService pointService){

        this.pointService = pointService;
    }
*/

}
