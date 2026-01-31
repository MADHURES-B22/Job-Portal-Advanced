package com.loga.Spring_rest_project.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    //Around always returns an object
    @Around("execution(* com.loga.Spring_rest_project.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();
        Object obj = jp.proceed(); //call the method
        long end = System.currentTimeMillis();

        LOGGER.info("Time Taken By "+jp.getSignature().getName() +" " + (end - start) + " ms" );
        return obj;
    }

}
