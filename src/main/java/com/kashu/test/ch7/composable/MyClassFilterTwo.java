package com.kashu.test.ch7.composable;

import org.springframework.aop.ClassFilter;

public class MyClassFilterTwo implements ClassFilter{
	
	//如果是BeanTwo.class，返回true，否則返回false
	public boolean matches(Class<?> cls) {
		return (cls == BeanTwo.class);
	}

}
