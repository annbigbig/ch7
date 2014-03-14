package com.kashu.test.ch7.composable;

import java.lang.reflect.Method;
import org.springframework.aop.support.StaticMethodMatcher;

public class MyMethodMatcherTwo extends StaticMethodMatcher{

	public boolean matches(Method method, Class<?> clz) {
		String methodName = method.getName();
		if(methodName.equals("hello2")||methodName.equals("hello3")){
			return true;
		}
		return false;
	}

}
