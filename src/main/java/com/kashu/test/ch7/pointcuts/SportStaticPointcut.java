package com.kashu.test.ch7.pointcuts;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

public class SportStaticPointcut  extends StaticMethodMatcherPointcut {

	//當target物件的函式名是run和jump的時候，返回true，否則返回false
	//-- return true when the name of the method of target object is 'run' or 'jump' , otherwise return false
	public boolean matches(Method method, Class<?> cls) {
		List<String> list = new ArrayList<String>();
		list.add(new String("run"));
		list.add(new String("jump"));
		String methodName = method.getName();
		for(String str : list){
			if(str.equals(methodName)){
				return true;
			}
		}
		return false;
	}

	//當target物件的類別型態是BeanTwo.class時，返回true，否則返回false
	//-- return true when the Class type of the target object is BeanTwo.class , otherwise return false
	public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> cls) {
                return (cls == BeanTwo.class);
            }
        };

    }
}
