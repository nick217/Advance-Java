package com.practice.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		TennisCoach coach = context.getBean("myTennisCoach", TennisCoach.class);

		// call methods on bean
		System.out.println(coach.getDailyWorkout());

		System.out.println(coach.getDailyFortune());

		// call our new methods to get literal values
		System.out.println(coach.getEmailAddress());
		System.out.println(coach.getTeam());

		// close the context
		context.close();
	}

}
