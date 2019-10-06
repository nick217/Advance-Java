package com.practice.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {

	private FortuneService fortuneService;

	@Autowired
	public CricketCoach(FortuneService fS) {
		fortuneService = fS;
	}

	@Override
	public String getDailyWorkout() {
		return "Run 5Kms";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
