package com.kashu.test.ch7.composable;

import java.lang.reflect.Method;
import org.springframework.aop.support.StaticMethodMatcher;

public class MyMethodMatcherOne extends StaticMethodMatcher{

	public boolean matches(Method method, Class<?> clz) {
		String methodName = method.getName();
		if(methodName.equals("hello1")||methodName.equals("hello2")){
			return true;
		}
		return false;
	}

}
