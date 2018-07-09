package com.prospective.web.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 使用order指定切面的优先级，值越小优先级越高
 */
@Order(1)
@Aspect
@Component
public class StudentAspect {

    /*
    申明切入点的表达式
     */
    @Pointcut("execution(* com.prospective.web.service.StudentServiceImpl.add())")
    public void declareJoinPointeExpression() {

    }

    /*
    前置通知
     */
    @Before("declareJoinPointeExpression()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("before method name: " + methodName);
    }

    /*
    后置通知
     */
    @After("declareJoinPointeExpression()")
    public void after(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("after method name: " + methodName);
    }

    /*
    返回通知
     */
    @AfterReturning(value = "declareJoinPointeExpression()",
            returning = "res")
    public void afterReturning(JoinPoint joinPoint, String res) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("after method name: " + methodName);
        System.out.println("return :" + res);
    }

    /*
    异常通知
     */
    @AfterThrowing(value = "declareJoinPointeExpression()",
            throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("after method name: " + methodName);
        ex.printStackTrace();
    }

    /*
    环绕通知需要携带ProceedingJoinPoint类似动态代理的全过程
    */
    @Around("declareJoinPointeExpression()")
    public void around(ProceedingJoinPoint point) throws Throwable {
        point.proceed();
    }
}
