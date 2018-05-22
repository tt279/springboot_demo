package com.example.demo.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.stereotype.Component;

@Component
public class BeanPostProcessorTest implements
        org.springframework.beans.factory.config.BeanPostProcessor{

    private static final Logger logger = LoggerFactory.getLogger(BeanPostProcessorTest.class);

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        logger.debug("[容器级]BeanPostProcessor.postProcessBeforeInitialization=" + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        logger.debug("[容器级]BeanPostProcessor.postProcessAfterInitialization=" + beanName);
        return bean;
    }

    static {
        logger.debug("加载BeanScannerConfigurer");
    }

}
