package com.kodilla.patterns2.decorator.pizza;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Watcher1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher1.class);

    @After("execution(* com.kodilla.patterns2.decorator.pizza.*.getCost(..))")
    public void logEvent1(JoinPoint joinPoint) {
        LOGGER.info("Type of decorator: " + joinPoint.getTarget().getClass().getName() + "; cost calculated");
    }

    @After("execution(* com.kodilla.patterns2.decorator.pizza.*.getDescription(..))")
    public void logEvent2(JoinPoint joinPoint) {
        LOGGER.info("Type of decorator: " + joinPoint.getTarget().getClass().getName() + "; description updated");
    }

    @Around("execution(* com.kodilla.patterns2.decorator.pizza.*.*(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Type of decorator: " + proceedingJoinPoint.getTarget().getClass().getName() +
                    "; method: " + proceedingJoinPoint.getSignature().getName() +
                    "; Time consumed: " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}