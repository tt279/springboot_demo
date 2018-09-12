package com.example.demo.service.impl;

import com.example.demo.dao.PointMapper;
import com.example.demo.service.PointService;
import com.example.demo.service.TestService;
import com.example.demo.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class PointServiceImpl implements PointService {

    @Autowired
    private PointMapper pointMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private TestService testService;
    @Autowired
    AopContext aopContext;

    static {
        System.out.println("PointServiceImpl static");
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public int insert(Long uid, Long num) {
        System.out.println(AopContext.currentProxy().hashCode());
        System.out.println(TransactionAspectSupport.currentTransactionStatus().hasSavepoint());

        pointMapper.insert(uid, num);

        try {
            testService.test();
        } catch (Exception e){
            System.out.println(TransactionAspectSupport.currentTransactionStatus().isRollbackOnly());
            e.printStackTrace();
        }

/*        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        System.out.println("PointServiceImpl:" + TransactionAspectSupport.currentTransactionStatus().isRollbackOnly());*/
        //int a = 1/0;
        return 0;
    }

/*    @Autowired
    public PointServiceImpl(UserService userService){

        this.userService = userService;
    }*/

}
