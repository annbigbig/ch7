package com.kashu.test.aop;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMyAdviceExample {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
    	context.load("classpath:aopTest/aopTest.xml");
    	context.refresh();    	
		
		SimpleService simpleService = (SimpleService) context.getBean("simpleServiceBean");
		simpleService.printNameId();
		System.out.println("---------------");
		try{
			simpleService.checkName();
		} catch(Exception e){
			System.out.println("SimpleService checkName() : Exception thrown..");
		}
		System.out.println("---------------");
		simpleService.sayHello("Javacodegeeks");
		System.out.println("---------------");
		context.close();
}

}
