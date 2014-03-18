package com.kashu.test.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DoAfterAspect {
	@Pointcut("execution(* com.kashu.test.aop.SimpleService.sayHello(..))")
	public void pointcutB(){
		
	}
	
	@After("pointcutB()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("***AspectJ*** DoAfter() is running!! intercepted : " + joinPoint.getSignature().getName());
	}
}
