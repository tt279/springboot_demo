package com.example.demo.processor;

import java.beans.PropertyDescriptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class InstantiationAwareBean implements InstantiationAwareBeanPostProcessor{

    private static final Logger logger = LoggerFactory.getLogger(InstantiationAwareBean.class);

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName)
            throws BeansException {
        logger.debug("[容器级]InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation："+ beanName);
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName)
            throws BeansException {
        logger.debug("[容器级]InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation："+ beanName);
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds,
            Object bean, String beanName) throws BeansException {
        logger.debug("[容器级]InstantiationAwareBeanPostProcessor.postProcessPropertyValues："+ beanName);
        return pvs;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        logger.debug("[容器级]InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization："+ beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        logger.debug("[容器级]InstantiationAwareBeanPostProcessor.postProcessAfterInitialization："+ beanName);
        return bean;
    }

    static {
        logger.debug("加载BeanScannerConfigurer");
    }
}
