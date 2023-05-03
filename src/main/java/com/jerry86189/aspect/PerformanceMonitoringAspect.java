package com.jerry86189.aspect;/**
 * @project flightTicket
 * @description TODO
 * @author Jerry
 * @date 2023/4/17 1:41
 * @version 1.0
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jerry
 * @version 1.0
 * @description: TODO
 * @date 2023/4/17 1:41
 */
@Aspect
@Component
public class PerformanceMonitoringAspect {

    private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

    /**
     * 监控目标方法的执行时间，并记录日志
     * @param joinPoint 切入点
     * @return 目标方法的返回结果
     * @throws Throwable 抛出的异常
     */

    @Around("execution(* com.jerry86189.service.impl.*.*(..))")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录方法执行开始时间
        long startTime = System.currentTimeMillis();

        // 执行目标方法
        Object result = joinPoint.proceed();

        // 记录方法执行结束时间，并计算方法执行时间
        long elapsedTime = System.currentTimeMillis() - startTime;
        // 输出方法执行时间日志
        logger.info("Method {} execution time: {} ms", joinPoint.getSignature().toShortString(), elapsedTime);

        return result;
    }
}
