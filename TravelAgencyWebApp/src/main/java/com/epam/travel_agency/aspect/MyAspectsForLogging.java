package com.epam.travel_agency.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MyAspectsForLogging {

    private final static Logger logger = LoggerFactory.getLogger(MyAspectsForLogging.class);

    @Pointcut("execution(public * com.epam.travel_agency.dao.impl..*.*(..))")
    public void inDaoPackage() {
    }

    @Before("inDaoPackage()")
    public void allDaoMethods(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature().getName() + " called with args: " + Arrays.toString(joinPoint.getArgs()));
    }

}
