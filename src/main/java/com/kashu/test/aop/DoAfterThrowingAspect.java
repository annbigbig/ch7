package com.kashu.test.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DoAfterThrowingAspect {
	
	   @AfterThrowing(pointcut = "execution(* com.kashu.test.aop.SimpleService.checkName(..))",throwing= "error")
	   public void doAfterThrowing(JoinPoint joinPoint, Throwable error) {
				System.out.println("***AspectJ*** DoAfterThrowing() is running!! intercepted : " + joinPoint.getSignature().getName());
				System.out.println("Exception : " + error);
				System.out.println("******");	 
	   }
 
}
