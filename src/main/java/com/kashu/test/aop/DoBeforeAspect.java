package com.kashu.test.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DoBeforeAspect {
	@Pointcut("execution(* com.kashu.test.aop.SimpleService.sayHello(..))")
	public void pointcutA(){
		
	}
	
	@Before("pointcutA()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature().getName());
	}
}
