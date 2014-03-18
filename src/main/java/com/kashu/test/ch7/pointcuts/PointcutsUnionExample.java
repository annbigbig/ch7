package com.kashu.test.ch7.pointcuts;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.Pointcuts;

public class PointcutsUnionExample {

	public static void main(String[] args) {
		FruitsStaticPointcut pc1 = new FruitsStaticPointcut();
		SportStaticPointcut pc2 = new SportStaticPointcut();
		
		//注意這裡，pc3是pc1和pc2的union
		Pointcut pc3 = Pointcuts.union(pc1, pc2);
		Advisor advisor = new DefaultPointcutAdvisor(pc3,new SimpleBeforeAdvice());
		
		BeanOne targetOne = new BeanOne();
		BeanTwo targetTwo = new BeanTwo();
		
		ProxyFactory pf = new ProxyFactory();
        pf.setTarget(targetOne);
        pf.addAdvisor(advisor);
        BeanOne proxyOne = (BeanOne)pf.getProxy();
        
        pf = new ProxyFactory();
        pf.setTarget(targetTwo);
        pf.addAdvisor(advisor);
        BeanTwo proxyTwo = (BeanTwo)pf.getProxy();
        
        proxyOne.apple();
        proxyOne.banana();
        proxyOne.hello();
        
        proxyTwo.jump();
        proxyTwo.run();
        proxyTwo.sleep();
		
	}


}
