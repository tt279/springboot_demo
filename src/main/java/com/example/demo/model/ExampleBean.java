package com.example.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ExampleBean implements BeanFactoryAware, BeanNameAware, ApplicationContextAware,
        InitializingBean, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(ExampleBean.class);

    private BeanFactory beanFactory;
    private String beanName;
    private ApplicationContext applicationContext;

    public ExampleBean() {
        logger.debug("【构造器】调用exampleBean的构造器实例化");
    }

    // 这是BeanFactoryAware接口方法
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.debug("[bean级]BeanFactoryAware.setBeanFactory：" + this.beanName);
        this.beanFactory = beanFactory;
    }

    // 这是BeanNameAware接口方法
    @Override
    public void setBeanName(String beanName) {
        logger.debug("[bean级]BeanNameAware.setBeanName："+ beanName);
        this.beanName = beanName;
    }

    // 这是ApplicationContextAware接口方法
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("[bean级]ApplicationContextAware.setApplicationContext：" + this.beanName);
        this.applicationContext = applicationContext;
    }

    // 这是InitializingBean接口方法
    @Override
    public void afterPropertiesSet() throws Exception {
        logger.debug("[bean级]InitializingBean.afterPropertiesSet: " + this.beanName);
    }

    // 这是DiposibleBean接口方法
    @Override
    public void destroy() throws Exception {
        logger.debug("[bean级]DiposibleBean.destory：" + this.beanName);
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void initMethod() {
        logger.debug("[bean级]bean.init-method属性指定的初始化方法：" + this.beanName);
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
    public void destroyMethod() {
        logger.debug("[bean级]bean.destroy-method属性指定的初始化方法：" + this.beanName);
    }

}
