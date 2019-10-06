package com.practice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container

		// Coach theCoach = context.getBean("myCoach", Coach.class);

		// use the default bean-id
		Coach theCoach = context.getBean("cricketCoach", Coach.class);

		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// close the context
		context.close();
	}

}
