package com.practice.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.practice.aopdemo.service.TrafficFortuneService;

public class AroundHandlingExceptionDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		System.out.println("\nMain program:: AroundDemoApp");

		System.out.println("Calling getFortune()");

		boolean tripWire = true;
		String data = fortuneService.getFortune(true);

		System.out.println("\nMy Fortune is: " + data);

		System.out.println("Finished");

		// close the context
		context.close();
	}

}
