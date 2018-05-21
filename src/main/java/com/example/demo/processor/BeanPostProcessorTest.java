package com.example.demo.processor;

import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorTest implements
        org.springframework.beans.factory.config.BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("[容器级]BeanPostProcessor.postProcessBeforeInitialization=" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("[容器级]BeanPostProcessor.postProcessAfterInitialization=" + beanName);
        return bean;
    }

    static {
        System.out.println("加载BeanScannerConfigurer");
    }

}
