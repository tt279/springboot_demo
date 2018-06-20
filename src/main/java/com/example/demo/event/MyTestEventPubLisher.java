package com.example.demo.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyTestEventPubLisher implements ApplicationContextAware,
        ApplicationListener<ContextStartedEvent>, BeanNameAware {

    private ApplicationContext applicationContext;

    private String beanName;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("ContextStartedEvent");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
