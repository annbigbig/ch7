/*
 * Created on Oct 7, 2011
 */
package com.apress.prospring3.ch7.introductions;

import org.springframework.aop.IntroductionAdvisor;
import org.springframework.aop.framework.ProxyFactory;

/**
 * @author clarence
 */
public class IntroductionExample {

    public static void main(String[] args) {
        // create the target
        TargetBean target = new TargetBean();
        target.setName("Clarence Ho");

        // create the advisor
        IntroductionAdvisor advisor = new IsModifiedAdvisor();

        // create the proxy
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        //設定為true才會使用CGLIB proxy，從工廠取出的proxy才會既是TargetBean又同時是isModified (代理的是類別和接口兩者)
        //書上是這麼寫，但我設定成false之後，取出的proxy一樣既是TargetBean又同時是isModified
        pf.setOptimize(true);
        
        TargetBean proxy = (TargetBean)pf.getProxy();
        IsModified proxyInterface = (IsModified)proxy;
        
        // test interfaces
        System.out.println("Is TargetBean?: " + (proxy instanceof TargetBean));
        System.out.println("Is IsModified?: " + (proxy instanceof IsModified));
        
        // test is modified implementation
        System.out.println("Has been modified?: " + proxyInterface.isModified());
        proxy.setName("Clarence Ho");
        System.out.println("Has been modified?: " + proxyInterface.isModified());
        proxy.setName("Rob Harrop");
        System.out.println("Has been modified?: " + proxyInterface.isModified());
     
    }
}