package com.kashu.test.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DoAroundAspect {
	@Around("execution(* com.kashu.test.aop.SimpleService.sayHello(..))")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("***AspectJ*** DoAround() is running!! intercepted : " +  joinPoint.getSignature().getName()
		+ " \narguments : "	+ Arrays.toString(joinPoint.getArgs()));

		System.out.println("***AspectJ*** DoAround() before is running!");
		Object retVal = joinPoint.proceed(); // continue on the intercepted method
		System.out.println("***AspectJ*** DoAround() after is running! and RETURN VALUE is " + retVal.toString());
		return retVal;
	}
}
