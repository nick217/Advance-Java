package com.practice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);

		Coach alphaCoach = context.getBean("myCoach", Coach.class);

		// check if these are the same beans
		boolean result = (theCoach == alphaCoach);

		// print the result
		System.out.println("Pointing to the same object: " + result);

		System.out.println("Memory location for theCoach: " + theCoach);

		System.out.println("Memory location for alpha coach: " + alphaCoach);

		// close the context
		context.close();
	}
}
