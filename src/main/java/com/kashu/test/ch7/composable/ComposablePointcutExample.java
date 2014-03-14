package com.kashu.test.ch7.composable;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class ComposablePointcutExample {

	public static void main(String[] args) {
		
		ComposablePointcut basePc = new ComposablePointcut();
		System.out.println("default behavior of ComposablePointcut");
		print2console(basePc);
		
		System.out.println("intersection with MyClassFilterOne");
		basePc.intersection(new MyClassFilterOne());
		print2console(basePc);
		
		System.out.println("union with MyMethodMatcherTwo");
		basePc.union(new MyClassFilterTwo());
		print2console(basePc);
		
		System.out.println("intersection with MyMethodMatcherOne");
		basePc.intersection(new MyMethodMatcherOne());
		print2console(basePc);
		
		System.out.println("union with MyMethodMatcherTwo");
		basePc.union(new MyMethodMatcherTwo());
		print2console(basePc);
		
		System.out.println("intersection with MyMethodMatcherThree");
		basePc.intersection(new MyMethodMatcherThree());
		print2console(basePc);
	}

	public static void print2console(ComposablePointcut pc){
		BeanOne targetOne = new BeanOne();
		BeanTwo targetTwo = new BeanTwo();
		BeanOne proxyOne;
		BeanTwo proxyTwo;
		ProxyFactory pf;
		Advisor advisor = new DefaultPointcutAdvisor(pc,new SimpleAroundAdvice());
		// get proxyOne
		pf = new ProxyFactory();
		pf.setTarget(targetOne);
		pf.addAdvisor(advisor);
		proxyOne = (BeanOne)pf.getProxy();
		//get proxyTwo
		pf = new ProxyFactory();
		pf.setTarget(targetTwo);
		pf.addAdvisor(advisor);
		proxyTwo = (BeanTwo)pf.getProxy();
		//
		proxyOne.hello1();
		proxyOne.hello2();
		proxyOne.hello3();
		proxyOne.hello4();
		//
		proxyTwo.hello1();
		proxyTwo.hello2();
		proxyTwo.hello3();
		proxyTwo.hello4();
	}

}
