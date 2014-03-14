package com.kashu.test.ch7.pointcuts;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class FruitsStaticPointcut extends StaticMethodMatcherPointcut{
	@Override
	public boolean matches(Method method, Class<?> cls) {
		List<String> list = new ArrayList<String>();
		list.add(new String("apple"));
		list.add(new String("banana"));
		String methodName = method.getName();
		for(String str : list){
			if(str.equals(methodName)){
				return true;
			}
		}
		return false;
	}

	public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> cls) {
                return (cls == BeanOne.class);
            }
        };

    }
}
