package com.example.demo.model;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
    /** Following is the definition for a pointcut to select
     *  all the methods available. So advice will be called
     *  for all the methods.
     */
    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    private void selectAll(){}
    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("beforeAdvice Logging");
    }
    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    @After("selectAll()")
    public void afterAdvice(){
        System.out.println("afterAdvice Logging");
    }

    @AfterThrowing("selectAll()")
    public void afterThrowingAdvice(){
        System.out.println("afterThrowingAdvice Logging");
    }
}