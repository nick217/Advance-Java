package com.practice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {

		// load the config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the beans
		Coach c1 = context.getBean("tennisCoach", Coach.class);
		Coach c2 = context.getBean("tennisCoach", Coach.class);

		System.out.println("Both same coach: " + (c1 == c2));

		System.out.println("Memory location of c1" + c1);

		System.out.println("Memory location of c2" + c2);

		// close the context
		context.close();
	}
}
