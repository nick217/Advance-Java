package com.practice.springdemo;

public class TennisCoach implements Coach {

	private FortuneService fortuneService;

	//add new fields for email address and team
	private String emailAddress;
	private String team;
	
	//create no-arg constructor
	public TennisCoach() {
		System.out.println("Tennis coach: Inside no-arg constructor");
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		System.out.println("Tennis Coach: inside setter method - setEmailAddress");
		this.emailAddress = emailAddress;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Tennis Coach: inside setter method - setTeam");
		this.team = team;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Tennis Coach: inside setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Perform variations of plank for 30 minutes";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
