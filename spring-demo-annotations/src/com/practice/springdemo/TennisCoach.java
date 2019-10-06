package com.practice.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("myCoach")
@Component // this will now use the default bean-id.
public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	// add default constructor
	public TennisCoach() {
		System.out.println(">> Tennis Coach: Inside default constructor");
	}
	/*
	 * @Autowired public TennisCoach(FortuneService fS) { fortuneService = fS; }
	 */

	// add setter method
	@Autowired
	public void setFortuneService(FortuneService fS) {
		System.out.println(">> TennisCoach: Inside setFortuneService()");
		fortuneService = fS;

	}

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
