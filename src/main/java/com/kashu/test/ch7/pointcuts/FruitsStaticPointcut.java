package com.kashu.test.ch7.pointcuts;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class FruitsStaticPointcut extends StaticMethodMatcherPointcut{
	//當target物件的函式名是apple和banana的時候，返回true，否則返回false
	//-- return true when the name of the method of target object is 'apple' or 'banana' , otherwise return false
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

	//當target物件的類別型態是BeanOne.class時，返回true，否則返回false
	//-- return true when the Class type of the target object is BeanOne.class , otherwise return false
	public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> cls) {
                return (cls == BeanOne.class);
            }
        };

    }
}
