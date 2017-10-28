package com.kodilla.patterns2.decorator.pizza;

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

    @After("execution(* com.kodilla.patterns2.decorator.pizza.*.getCost(..)) && target(object)")
    public void logEvent1(Object object) {
        LOGGER.info("Type of decorator: " + object.getClass().getName() + "; cost calculated");
    }

    @After("execution(* com.kodilla.patterns2.decorator.pizza.*.getDescription(..)) && target(object)")
    public void logEvent2(Object object) {
        LOGGER.info("Type of decorator: " + object.getClass().getName() + "; description updated");
    }

    @Around("execution(* com.kodilla.patterns2.decorator.pizza.*.*(..)) && target(object)")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint, Object object) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Type of decorator: " + object.getClass().getName() +
                    "; method: " + proceedingJoinPoint.getSignature().getName() +
                    "; Time consumed: " + (end - begin) + "[ms]");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}