/**
 * Created on Oct 3, 2011
 */
package com.apress.prospring3.ch7.aspectjannotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Clarence
 *
 */
@Component
@Aspect
public class MyAdvice {

	//@Pointcut("execution(* com.apress.prospring3.ch7..foo*(int)) && args(intValue)")
	@Pointcut("execution(* com.apress.prospring3.ch7..foo*(int)) && args(intValue)")
	public void fooExecution(int intValue) {
	}
	
	//羚羊七百拿掉下面這行的注解會出錯
	//@Pointcut("bean(myDependency*)")
	public void inMyDependency() {
	}
	
	@Pointcut("execution(* com.apress.prospring3.ch7..tony*(int)) && args(intValue)")
	public void tonyExecution(int intValue){
		
	}
	
	//前兩個@Before根本就不能讓Pointcut相加
	//@Before("fooExecution(intValue) && inMyDependency()")
	//@Before("fooExecution(intValue) && tonyExecution(intValue)")
	@Before("fooExecution(intValue)")
	public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
		// Execute only when intValue is not 100
		if (intValue != 100) {
		    System.out.println("Executing: " + joinPoint.getSignature().getDeclaringTypeName() + " " 
	            + joinPoint.getSignature().getName()
	            + " argument: " + intValue);
		}
	}
	
	@Before("tonyExecution(intValue)")
	public void forTonyAdvice(JoinPoint joinPoint,int intValue){
		System.out.println("Executing : forTonyAdvice() " + intValue);
	}
	
	//@Around("fooExecution(intValue) && inMyDependency()")
	@Around("fooExecution(intValue)")
	public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int intValue) throws Throwable {
		
	    System.out.println("Before execution: " + pjp.getSignature().getDeclaringTypeName() + " " 
	            + pjp.getSignature().getName()
	            + " argument: " + intValue);

	    Object retVal = pjp.proceed();
	    
	    System.out.println("After execution: " + pjp.getSignature().getDeclaringTypeName() + " " 
	            + pjp.getSignature().getName()
	            + " argument: " + intValue);	    
	    
	    return retVal;
	}	
	
}
