package com.jerry86189.aspect;/**
 * @project flightTicket
 * @description TODO
 * @author Jerry
 * @date 2023/4/17 1:35
 * @version 1.0
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Jerry
 * @version 1.0
 * @description: TODO
 * @date 2023/4/17 1:35
 */
@Aspect
@Component
public class LoggingAspect {

    // 日志记录器
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * 在目标方法执行前记录日志
     * @param joinPoint 切点
     */

    @Before("execution(* com.jerry86189.service.impl.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Entering method: {} ", joinPoint.getSignature().toShortString());
    }

    /**
     * 在目标方法执行后记录日志
     * @param joinPoint 切点
     */

    @After("execution(* com.jerry86189.service.impl.*.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        logger.info("Exiting method: {}", joinPoint.getSignature().toShortString());
    }

    /**
     * 在目标方法发生异常时记录日志
     * @param joinPoint 切点
     * @param error 异常信息
     */

    @AfterThrowing(pointcut = "execution(* com.jerry86189.service.impl.*.*(..))", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        logger.error("An error occurred in method: {} ", joinPoint.getSignature().toShortString(), error);
    }
}
