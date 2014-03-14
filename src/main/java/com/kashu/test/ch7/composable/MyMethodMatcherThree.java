package com.kashu.test.ch7.composable;

import java.lang.reflect.Method;
import org.springframework.aop.support.StaticMethodMatcher;

public class MyMethodMatcherThree extends StaticMethodMatcher{
	public boolean matches(Method method, Class<?> clz) {
		String methodName = method.getName();
		if(methodName.equals("hello3")||methodName.equals("hello4")){
			return true;
		}
		return false;
	}
}
