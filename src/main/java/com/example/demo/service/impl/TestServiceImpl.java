package com.example.demo.service.impl;

import com.example.demo.dao.PointMapper;
import com.example.demo.myproxy.ScanClass1;
import com.example.demo.service.TestService;
import com.example.demo.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
//@Scope(value = "prototype" , proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestServiceImpl implements TestService, InitializingBean {

    @Autowired
    private UserService userService;
    //@Autowired
    private ScanClass1 scanClass1;

    @Autowired
    private PointMapper pointMapper;

    @Transactional
    @Override
    public void test() {
        pointMapper.insert(11L,11L);
        System.out.println(AopContext.currentProxy().hashCode());
        System.out.println(TransactionAspectSupport.currentTransactionStatus().hasSavepoint());
        System.out.println(TransactionAspectSupport.currentTransactionStatus().isRollbackOnly());

        System.out.println("test scope");
        System.out.println("Service:" +this);
        System.out.println("Service:" +userService);
        System.out.println("Service:" +userService);
        int a = 1/0;
    }

    @Override
    public void testScan() {
        scanClass1.print();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }

}
