package com.loga.Spring_rest_project.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {


    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // @Before(return type class-name.Method-name(args)) Happens before the message called
    @Before("execution(* com.loga.Spring_rest_project.service.JobService.getjob(..))")
    public void logMethodcall(JoinPoint jp){
        LOGGER.info("Method Called : " + jp.getSignature().getName());
    }

    //Happens always irrespective of error after the method finished
    @After("execution(* com.loga.Spring_rest_project.service.JobService.getjob(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method Executed" + jp.getSignature().getName());
    }

    //Log message after having an errror
    @AfterThrowing("execution(* com.loga.Spring_rest_project.service.JobService.getjob(..))")
    public void logMethodcrash(JoinPoint jp){
        LOGGER.info("Method has Error" + jp.getSignature().getName());
    }

    //Log message after Successfull Execution
    @AfterReturning("execution(* com.loga.Spring_rest_project.service.JobService.getjob(..))")
    public void logMethodsucces(JoinPoint jp){
        LOGGER.info("Method has Executed Successfully" + jp.getSignature().getName());
    }

}
