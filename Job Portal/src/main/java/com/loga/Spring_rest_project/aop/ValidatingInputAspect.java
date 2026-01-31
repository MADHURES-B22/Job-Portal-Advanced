package com.loga.Spring_rest_project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidatingInputAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidatingInputAspect.class);

    @Around("execution(* com.loga.Spring_rest_project.service.JobService.getjob(..)) && args(postId)")
    public Object ValidatingInputandUpdate(ProceedingJoinPoint jp, int postId) throws Throwable {

        LOGGER.info("Input is Negative, Updating PostId");
        if(postId < 0){
            postId = -postId;
        }
        LOGGER.info("new PostId : " +postId);
        Object obj = jp.proceed(new Object[]{postId});
        return obj;
    }

}
