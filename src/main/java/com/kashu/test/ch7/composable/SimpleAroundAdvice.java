package com.kashu.test.ch7.composable;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAroundAdvice implements MethodInterceptor{

	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.print("=====>");
		Object retValue = invocation.proceed();
		printInvocationDetail(invocation);
		return retValue;
	}
	
	public void printInvocationDetail(MethodInvocation invocation){
		Method method = invocation.getMethod();
		Object target = invocation.getThis();
		Object[] args = invocation.getArguments();
		int argsCount = args.length;
		String msg = "Target Class = " + target.getClass().getName() + "\t\t Method =" + method.getName() + "\t\t argsCount=" + argsCount;
		System.out.println(msg);
	}

}
