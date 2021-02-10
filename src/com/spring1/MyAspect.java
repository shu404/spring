package com.spring1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("myAspect")
@Aspect
public class MyAspect {
    //value属性指定切入点表达式
    @Before(value="execution(* com.spring1.*.*(..))")
    public void myBefore(JoinPoint jp){
        System.out.println("before");
    }
    //用空方法声明全局的切入点表达式
    @Pointcut(value = "execution(* com.spring1.*.*(..))")
    public void pc1(){}
    @AfterReturning(value = "pc1()",returning = "result")
    public void myAfterReturning(JoinPoint jp,Object result){
        System.out.println("afterReturning");
    }
    @AfterThrowing(value = "pc1()",throwing = "e")
    public void myThrowing(JoinPoint jp,Throwable e){
        System.out.println("throwing");
    }
    @After(value = "pc1()")
    public void myAfter(JoinPoint jp){
        System.out.println("after");
    }
    @Around(value = "pc1()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("around before");
        Object o = pjp.proceed();
        System.out.println("around after");
        return o;
    }
}
