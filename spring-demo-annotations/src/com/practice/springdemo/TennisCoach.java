package com.practice.springdemo;

import org.springframework.stereotype.Component;

//@Component("myCoach")
@Component // this will now use the default bean-id.
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
