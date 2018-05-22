package com.example.demo.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    private static final Logger logger = LoggerFactory.getLogger(BeanFactoryPostProcessorTest.class);

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
            throws BeansException {
        logger.debug("[容器级]BeanFactoryPostProcessor.postProcessBeanFactory");
    }

    static {
        logger.debug("加载BeanScannerConfigurer");
    }

}
