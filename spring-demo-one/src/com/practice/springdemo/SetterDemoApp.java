package com.practice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		Coach coach = context.getBean("myTennisCoach", Coach.class);

		// call methods on bean
		System.out.println(coach.getDailyWorkout());

		System.out.println(coach.getDailyFortune());

		// close the context
		context.close();
	}

}
