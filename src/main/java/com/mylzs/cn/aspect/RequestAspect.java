package com.mylzs.cn.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 17/12/4.
 */
@Aspect
@Component
public class RequestAspect {
Logger logger=Logger.getLogger(RequestAspect.class);
@Pointcut("execution(public  * com.mylzs.cn.*.controller.*.*(..))")
public void log(){

}
    @Before("log()")
    public  void  doBefore(JoinPoint joinPoint){

        logger.info("方法执行前");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("url:"+request.getRequestURI());
        logger.info("ip:"+request.getRemoteHost());
        logger.info("method class:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());

    }
    @After("log()")
    public  void  doAfter(JoinPoint joinPoint){
        logger.info("方法执行后");

    }
    @AfterReturning(pointcut = "log()",returning = "result")
    public  void  doAfterReturning(Object result){
        logger.info("方法执行后的值："+result);

    }
}
