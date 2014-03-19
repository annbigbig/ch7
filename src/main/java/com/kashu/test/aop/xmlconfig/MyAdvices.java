package com.kashu.test.aop.xmlconfig;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvices {
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("***AspectJ*** DoAfter() is running!! intercepted : " + joinPoint.getSignature().getName());
	}
	
	public void doAfterReturning(JoinPoint joinPoint, String message,Object result) {
		System.out.println("***AspectJ*** DoAfterReturning() is running!! intercepted : " + joinPoint.getSignature().getName());
		System.out.println("message=" + message + "  Method returned value is : " + result);
	}
	
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("***AspectJ*** DoAround() is running!! intercepted : " +  joinPoint.getSignature().getName()
		+ " \narguments : "	+ Arrays.toString(joinPoint.getArgs()));

		System.out.println("***AspectJ*** DoAround() before is running!");
		Object retVal = joinPoint.proceed(); // continue on the intercepted method
		System.out.println("***AspectJ*** DoAround() after is running! and RETURN VALUE is " + retVal.toString());
		return retVal;
	}
	
	public void doBefore(JoinPoint joinPoint,String message){
		System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature().getName() + "  message = " + message);
	}
	
	public void doAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("***AspectJ*** DoAfterThrowing() is running!! intercepted : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");	 
	 }
	
	public void showMethodDetail(JoinPoint joinPoint){
		System.out.println("***AspectJ*** showMethodDetail() is running!! intercepted : " + joinPoint.getSignature().getName() );
	}
}
