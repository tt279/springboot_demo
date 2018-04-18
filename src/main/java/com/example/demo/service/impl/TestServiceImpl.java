package com.example.demo.service.impl;

import com.example.demo.service.TestService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Scope(value = "prototype" , proxyMode = ScopedProxyMode.TARGET_CLASS)
public class TestServiceImpl implements TestService, InitializingBean {

    @Autowired
    private UserService userService;

    @Override
    public void test() {
        System.out.println("test scope");
        System.out.println("Service:" +this);
        System.out.println("Service:" +userService);
        System.out.println("Service:" +userService);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
