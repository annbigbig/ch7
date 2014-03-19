package com.kashu.test.aop.aspectjannotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAdvices {
	// 套用advice於指定包指定接口的sayHello函式，並將String型態的message參數傳給advice (這會影響到advice函式宣告時所帶的參數數量)
	@Pointcut("execution(* com.kashu.test.aop.aspectjannotation.SimpleService.sayHello(String)) && args(message)")
	public void pointcut1(String message){
		
	}
	
	// 套用advice於指定包指定接口的sayHello函式，不會傳遞參數給advice
	@Pointcut("execution(* com.kashu.test.aop.aspectjannotation.SimpleService.sayHello(..))")
	public void pointcut2(){
		
	}
	
	//套用advice於指定包指定接口的名稱以check開頭的函式，不會傳遞參數給advice
	@Pointcut("execution(* com.kashu.test.aop.aspectjannotation.SimpleService.check*(..))")
	public void pointcut3(){
		
	}
	
	//套用advice於所有名稱以print開頭的函式 ，不會傳遞參數給advice
	@Pointcut("execution(* print*(..))")
	public void pointcut4(){
		
	}
	
	//套用advice於指定包指定接口的所有函式 ，不會傳遞參數給advice
	@Pointcut("execution(* com.kashu.test.aop.aspectjannotation.SimpleService.*(..))")
	public void pointcut5(){
		
	}
	
	@After("pointcut2()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("***AspectJ*** DoAfter() is running!! intercepted : " + joinPoint.getSignature().getName());
	}
	
	@AfterReturning(pointcut="pointcut1(message)",returning="result")
	public void doAfterReturning(JoinPoint joinPoint, String message,Object result) {
		System.out.println("***AspectJ*** DoAfterReturning() is running!! intercepted : " + joinPoint.getSignature().getName());
		System.out.println("message=" + message + "  , Method returned value is : " + result);
	}
	
	@Around("pointcut2()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("***AspectJ*** DoAround() is running!! intercepted : " +  joinPoint.getSignature().getName()
		+ " \narguments : "	+ Arrays.toString(joinPoint.getArgs()));

		System.out.println("***AspectJ*** DoAround() before is running!");
		Object retVal = joinPoint.proceed(); // continue on the intercepted method
		System.out.println("***AspectJ*** DoAround() after is running! and RETURN VALUE is " + retVal.toString());
		return retVal;
	}
	
	@Before("pointcut1(message)")
	public void doBefore(JoinPoint joinPoint,String message){
		System.out.println("***AspectJ*** DoBefore() is running!! intercepted : " + joinPoint.getSignature().getName() + "  message = " + message);
	}
	
	//@Before("pointcut5()")
	public void showMethodDetail(JoinPoint joinPoint){
		System.out.println("***AspectJ*** showMethodDetail() is running!! intercepted : " + joinPoint.getSignature().getName() );
	}
	
	@AfterThrowing(pointcut = "pointcut3()",throwing= "error")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable error) {
		System.out.println("***AspectJ*** DoAfterThrowing() is running!! intercepted : " + joinPoint.getSignature().getName());
		System.out.println("Exception : " + error);
		System.out.println("******");	 
	 }
	
}
