package com.practice.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;

	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {

		return "Just Do it: " + fortuneService.getFortune();
	}

	// add an init method
	public void doMyStartUpStuff() {
		System.out.println("TrackCoach: Inside method doMyStartUpStuff");
	}

	// add destroy method
	public void doMyCleanUpStuff() {
		System.out.println("TrackCoach: Inside method doMyCleanUpStuff");
	}
}
