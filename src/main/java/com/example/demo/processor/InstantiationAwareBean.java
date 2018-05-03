package com.example.demo.processor;

import java.beans.PropertyDescriptor;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author ldy
 * @date 2018-04-16 18:35
 */
@Component
public class InstantiationAwareBean implements InstantiationAwareBeanPostProcessor{

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
            throws BeansException {
        System.out.println("[容器级]InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation："+ beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName)
            throws BeansException {
        System.out.println("[容器级]InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation："+ beanName);
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds,
            Object bean, String beanName) throws BeansException {
        System.out.println("[容器级]InstantiationAwareBeanPostProcessor.postProcessPropertyValues："+ beanName);
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("[容器级]InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization："+ beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out.println("[容器级]InstantiationAwareBeanPostProcessor.postProcessAfterInitialization："+ beanName);
        return bean;
    }
}
